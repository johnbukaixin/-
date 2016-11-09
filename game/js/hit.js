/**
 * Created by Administrator on 2016/7/14/0014.
 */

function hit(shot,diji){

    //子弹在左边
    var condition1=(shot.x+shot.img.width)<diji.x;
    //子弹在右边
    var condition2=shot.x>(diji.x+diji.img.width);

    //子弹在上边
    var condition3=(shot.y+shot.img.height)<diji.y;
    //子弹在下边
    var condition4=shot.y>diji.y+diji.img.height;

    if(condition1||condition2||condition3||condition4){

    }else{
    //    撞上
        diji.die();
        shot.die();
        if(g_hero.isdie==1)return;
        var audio=new Audio();
        audio.src="../source/boom.mp3";
        audio.play();
        g_score++;
        var node=document.getElementById("score");
        node.innerHTML="SCORE: "+g_score;

    }
}

function hitHero(hero,diji){
    if(hero.isdie==1)return;
    //子弹在左边
    var condition1=(hero.x+hero.img1.width)<diji.x;
    //子弹在右边
    var condition2=hero.x>(diji.x+diji.img.width);

    //子弹在上边
    var condition3=(hero.y+hero.img1.height)<diji.y;
    //子弹在下边
    var condition4=hero.y>diji.y+diji.img.height;

    if(condition1||condition2||condition3||condition4){

    }else{
        //    撞上
      hero.die();
        var audio=new Audio();
        audio.src="../source/fail.wav";
        audio.play();

    }
}
