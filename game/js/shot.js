/**
 * Created by Administrator on 2016/7/13/0013.
 */
function shot(x,y,imgID){
    //      ********** �����޸Ĺ�*********
    this.x=g_hero.x+g_hero.img1.width;
    //this.y=g_hero.y+g_hero.img1.height*0.333;
    //this.x=x;
    this.y=y;
    this.img=document.getElementById(imgID);
    //this.width=7;
    //this.height=5;
    //��ſ�µ�ʱ��
    if(g_hero.isDun==1){
        this.x+=23;
        this.y+=20;
    }
    //������ʱ��
    if(g_hero.isjump==1){
        this.y=g_hero.jumpy+g_hero.img1.height*0.333;
    }
    if(g_hero.isjump==2){
        this.y=g_hero.jumpy+g_hero.img1.height*2;
    }
}

shot.prototype.show=function(){
    //    ***********�����޸Ĺ�************
    g_context.drawImage(this.img,this.x,this.y);
    //g_shotArray.push(new shot(520,130,'shot'));
    this.x+=3;
//    ��ײ���,��ÿһ���л����м��
    for(var i=0;i<g_dijiArray.length;i++){
        hit(this,g_dijiArray[i]);
    }

}
shot.prototype.removeShot= function () {
    if(this.x>500){
        //���ӵ�������Ļ����Ҫ������������Ƴ�
        var index=g_shotArray.indexOf(this);
        g_shotArray.splice(index,1);
    }
}
shot.prototype.die=function(){
    var index=g_shotArray.indexOf(this);
    g_shotArray.splice(index,1);
}



