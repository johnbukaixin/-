/**
 * Created by Administrator on 2016/7/13/0013.
 */
function BackGround(x,y,imgID){
//    ���屳���� x,y�ֱ�Ϊ������������꣬������ڡ�����������������
    this.x=x;
    this.y=y;
    this.img=document.getElementById(imgID);
    this.x2=this.x+this.img.width;
}

//��ʼ����
BackGround.prototype.show=function(){
//    ����ǰ��������show����
//    ����drawImage()
    g_context.drawImage(this.img,this.x,this.y);
    g_context.drawImage(this.img,this.x2,this.y);
    //this.x2--;
    //this.x--;
    //��ͼƬ��������������ÿ���
    this.x-=g_speed;
    this.x2-=g_speed;
    //��x��Խ�߽���Ҫ���Ļص��ұ�
    if(this.x<=this.img.width*-1){
        this.x=this.img.width;
    }
    if(this.x2<=this.img.width*-1){
        this.x2=this.img.width;
    }
}

BackGround.prototype.onPause=function(){
    g_context.drawImage(this.img,this.x,this.y);
    g_context.drawImage(this.img,this.x2,this.y);
    //��x��Խ�߽���Ҫ���Ļص��ұ�
    if(this.x<=this.img.width*-1){
        this.x=this.img.width;
    }
    if(this.x2<=this.img.width*-1){
        this.x2=this.img.width;
    }
}
