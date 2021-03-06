#!/bin/bash

usage(){
	echo "Usage: $0 -v <desired version> -g <gpg password>"
	exit 1
}

while getopts ":hv:g:" opt
do
   case ${opt} in
       v)
           version=${OPTARG}
           ;;
       g)
           gpg_pass=${OPTARG}
           ;;
       h)
           usage
           exit 0
           ;;

       \?)
           echo -e "Invalid option: -${OPTARG}"
           exit 1
           ;;

       :)
           echo -e "Option -${OPTARG} require argument."
           exit 2
           ;;
   esac
done

shift $(( ${OPTIND} - 1 ))

if [ $# -ne 0 ]
then
   echo "There are unexpected parameters!" 1>&2
   usage
   exit 1
fi

if [ -z "${version}" ]
then
   echo "No version given!"
   usage
   exit 1
fi

if [ -z "${gpg_pass}" ]
then
   echo "No gpg password given!"
   usage
   exit 1
fi

mvn --batch-mode release:prepare release:perform -DreleaseVersion=${version} -Darguments="-Dgpg.passphrase=${gpg_pass}" 
sed -i "s/\(<version>\)[0-9]*\.[0-9]*\.[0-9]*\(<\/version>\)/\1${version}\2/" README.md
git commit -a -m "bump version"
git push origin --tags HEAD
