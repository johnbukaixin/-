/**
 * Created by Administrator on 2016/7/13/0013.
 */
function hero(x,y,imgID1,imgID2){
    this.x=x;
    this.y=y;
    this.jumpy=this.y;
    this.img1=document.getElementById(imgID1);
    this.img2=document.getElementById(imgID2);
    //定义一个变量，用来控制绘制不同的图片
    this.count=0;

    isDun=0;


    this.isjump=0;
    this.direction="up";
    this.isdie=0;
}
//
hero.prototype.show=function() {
    if(this.isdie==1)
    return;
    this.count++;
    if (this.isDun == 1) {
        var dunImg = document.getElementById("hero3");
        g_context.drawImage(dunImg,this.x,this.y+25);
    }else if(this.isjump==1) {
        g_context.drawImage(this.img1, this.x, this.jumpy);
        //改变移动速度
        g_speed=8;
        // 如果正在往上跑的话
        if (this.direction == "up") {
            if (this.jumpy >= 50) {
                this.jumpy-=3;
            } else {
                this.direction = "down";
            }
        }
            if (this.direction == "down") {
                if (this.jumpy <= this.y) {
                    this.jumpy+=3;

                } else {
                    this.isjump = 0;
                    this.direction = "up";
                    g_speed=5;
                }

            }

    }
    else {
        if (this.count % 4 == 0) {
            g_context.drawImage(this.img1, this.x, this.y);
        } else {
            g_context.drawImage(this.img2, this.x, this.y);
        }

    }
//    英雄是否掉水里
    if(this.isjump==1)return;
    if(this.isdie==1)return;
    if(this.x>g_background.x&&this.x<g_background.x+60){
        this.die();
        var audio=new Audio();
        audio.src="../source/fail.wav";
        audio.play();
    }else if(this.x>g_background.x2&&this.x<g_background.x2+60){
        this.die();
        var audio=new Audio();
        audio.src="../source/fail.wav";
        audio.play();
    }
}

hero.prototype.die=function(){
    this.isdie=1;
    over.style.display="block";

}