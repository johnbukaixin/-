/**
 * Created by Administrator on 2016/7/14/0014.
 */
function diji(x,y,imgID,blood){

    this.x=x;
    this.y=y;
    this.blood=blood;
    this.img=document.getElementById(imgID);
}



diji.prototype.show=function(){
    g_context.drawImage(this.img,this.x,this.y);
    this.x-=(g_speed+1);

//    ���Ӣ�������ɻ�

    hitHero(g_hero,this);
}
//�������Ͳ�����ͬ���ел�
function makeDijiWithType(flag){
   if(flag==1){
   //    �����л�
       g_dijiArray.push(new diji(520,130,'d1',2));
   }
    if(flag==2){
        //    �����л�
        g_dijiArray.push(new diji(520,100,'d2',1));
        g_dijiArray.push(new diji(480,130,'d1',2));
        g_dijiArray.push(new diji(520,130,'d2',1));
    }
    if(flag==3){
        //    �����л�
        g_dijiArray.push(new diji(520,100,'d2',1));
        g_dijiArray.push(new diji(560,100,'d1',2));
        g_dijiArray.push(new diji(600,100,'d3',1));
    }
    if(flag==4){
        //    �����л�
        g_dijiArray.push(new diji(520,70,'d2',1));
        g_dijiArray.push(new diji(520,100,'d1',2));
        g_dijiArray.push(new diji(520,130,'d3',1));
        g_dijiArray.push(new diji(520,160,'d2',1));
    }
    if(flag==5){
        //    �����л�
        g_dijiArray.push(new diji(600,70,'d2',1));
    }
    if(flag==6){
        //    �����л�
        g_dijiArray.push(new diji(520,50,'d2',1));
        g_dijiArray.push(new diji(560,80,'d1',2));
        g_dijiArray.push(new diji(600,110,'d3',1));
    }
    if(flag==7){
        //    �����л�
        g_dijiArray.push(new diji(480,50,'d2',1));
        g_dijiArray.push(new diji(560,80,'d2',1));
        g_dijiArray.push(new diji(480,110,'d3',1));
    }
    if(flag==8){
        //    �����л�
        g_dijiArray.push(new diji(480,50,'d2',1));
        g_dijiArray.push(new diji(520,80,'d1',2));
        g_dijiArray.push(new diji(540,110,'d3',1));
        g_dijiArray.push(new diji(500,140,'d1',2));
    }
}
diji.prototype.removeDiji= function () {
    if (this.x < -50) {
        //��diji������Ļ����Ҫ������������Ƴ�
        var index = g_dijiArray.indexOf(this);
        g_dijiArray.splice(index, 1);
    }
}


diji.prototype.die=function(){
    this.blood--;
    //Ѫ��û�ˣ��Ų��Ƴ�
    if(this.blood==0){
        var index = g_dijiArray.indexOf(this);
        g_dijiArray.splice(index, 1);
    }


}