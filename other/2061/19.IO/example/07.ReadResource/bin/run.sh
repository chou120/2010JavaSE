cd `dirname $0`
cd ..
DEPLOY_DIR=`pwd`
MAIN_CLASS="club.banyuan.ReadProperties"
echo $DEPLOY_DIR
echo $MAIN_CLASS
java -cp $DEPLOY_DIR:$DEPLOY_DIR/07.ReadResource.jar  $MAIN_CLASS
