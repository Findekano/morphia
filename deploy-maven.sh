#!/bin/bash
VERSION=0.105.adsk
REPOURL=http://a360nexus.autodesk.com/nexus/content/repositories/thirdparty/
LOCAL_REPO=/home/jay/.m2/repository/org/mongodb/morphia/

for NAME in `ls $LOCAL_REPO`; do 
	FILE_NAME=$LOCAL_REPO/$NAME/$VERSION/$NAME-$VERSION

	if [ -f $FILE_NAME.jar ]; then
		mvn2 deploy:deploy-file -Dfile=$FILE_NAME.jar -DpomFile=$FILE_NAME.pom  -DrepositoryId=snapshots -Durl=$REPOURL
	else
		mvn2 deploy:deploy-file -Dfile=$FILE_NAME.pom -DpomFile=$FILE_NAME.pom  -DrepositoryId=snapshots -Durl=$REPOURL
	fi
done;
