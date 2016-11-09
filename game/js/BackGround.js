/**
 * Created by Administrator on 2016/7/13/0013.
 */
function BackGround(x,y,imgID){
//    定义背景类 x,y分别为横坐标和纵坐标，传参入口。把它付给对象属性
    this.x=x;
    this.y=y;
    this.img=document.getElementById(imgID);
    this.x2=this.x+this.img.width;
}

//开始绘制
BackGround.prototype.show=function(){
//    给当前对象增加show函数
//    调用drawImage()
    g_context.drawImage(this.img,this.x,this.y);
    g_context.drawImage(this.img,this.x2,this.y);
    //this.x2--;
    //this.x--;
    //让图片动起来，减二变得快了
    this.x-=g_speed;
    this.x2-=g_speed;
    //当x超越边界需要中心回到右边
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
    //当x超越边界需要中心回到右边
    if(this.x<=this.img.width*-1){
        this.x=this.img.width;
    }
    if(this.x2<=this.img.width*-1){
        this.x2=this.img.width;
    }
}
