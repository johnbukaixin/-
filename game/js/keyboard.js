/**
 * Created by Administrator on 2016/7/13/0013.
 */
//¼üÅÌÉýÆð
function keyUp(e){
    if(e.keyCode==38|| e.keyCode==32) {

    }else if(e.keyCode==65){

    }else if(e.keyCode==40){
        g_hero.isDun=0;
    }
}
//¼üÅÌ°´ÏÂ
function keyDown(e){

   if(e.keyCode==38) {
       g_hero.isjump=1;

   }else if(e.keyCode==38&& e.keyCode==17){
       g_hero.isjump=2;
   }
   else if(e.keyCode==65){
       if(g_hero.isdie==1)return;
           g_shotArray.push(new shot(110, 100, 'shot'));

           var audio = new Audio();
           audio.src = "../source/hdl.mid";
           audio.play();

   }else if(e.keyCode==83){
       if(g_hero.isdie==1)return;
       g_shotArray.push(new shot(110,80,'shot'));
       g_shotArray.push(new shot(110,100,'shot'));
       g_shotArray.push(new shot(110,120,'shot'));
   }
   else if(e.keyCode==40){
       g_hero.isDun=1;

   }
}