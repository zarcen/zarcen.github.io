
var touchtimes = 0;
var yOffsetOnTouchStart;
var yOffsetOnTouchEnd;
var offset_arr = [];
var yPos_arr = [];
var touchOnTiming = [];
var touchEndTiming = [];
var c=0; // timing, unit:second
var t; // var for timer

function taskSelect() {
  var pid = $(".1-32").val();
  if ( pid % 16 == 1 ) {
    window.location = "http://zarcen.github.io/fixed.html";
  }
  else if ( pid % 16 == 2 ) {
    window.location = "http://zarcen.github.io/fixed2.html";
  }
  else if ( pid % 16 == 3 ) {
    window.location = "http://zarcen.github.io/fixed.html";
  }
  else if ( pid % 16 == 4 ) {
    window.location = "http://zarcen.github.io/fixed2.html";
  }
  else if ( pid % 16 == 5 ) {
    window.location = "http://zarcen.github.io/fixed.html";
  }
  else if ( pid % 16 == 6 ) {
    window.location = "http://zarcen.github.io/fixed2.html";
  }
  else if ( pid % 16 == 7 ) {
    window.location = "http://zarcen.github.io/fixed.html";
  }
  else if ( pid % 16 == 8 ) {
    window.location = "http://zarcen.github.io/fixed2.html";
  }
  else if ( pid % 16 == 9 ) {
    window.location = "http://zarcen.github.io/fluid.html";
  }
  else if ( pid % 16 == 10 ) {
    window.location = "http://zarcen.github.io/fluid2.html";
  }
  else if ( pid % 16 == 11 ) {
    window.location = "http://zarcen.github.io/fluid.html";
  }
  else if ( pid % 16 == 12 ) {
    window.location = "http://zarcen.github.io/fluid2.html";
  }
  else if ( pid % 16 == 13 ) {
    window.location = "http://zarcen.github.io/fluid.html";
  }
  else if ( pid % 16 == 14 ) {
    window.location = "http://zarcen.github.io/fluid2.html";
  }
  else if ( pid % 16 == 15 ) {
    window.location = "http://zarcen.github.io/fluid.html";
  }
  else if ( pid % 16 == 0 ) {
    window.location = "http://zarcen.github.io/fluid2.html";
  }
}


function myTouchStartHandler() {
  yOffsetOnTouchStart = window.pageYOffset;
  touchtimes+=1;
  touchOnTiming.push(c);
  //$('#offsetLogs').val('hi');
}

function myTouchEndHandler() {
  yOffsetOnTouchEnd = window.pageYOffset;
  if(yOffsetOnTouchEnd - yOffsetOnTouchStart != 0) {
    offset_arr.push(yOffsetOnTouchEnd - yOffsetOnTouchStart);
    touchEndTiming.push(c);
  }
  else {
    touchtimes-=1;
    touchOnTiming.pop();
  }
}

function taskStart() {
  document.getElementById('timeConsuming').value=c;
  c=c+1;
  t=setTimeout("timedCount()",1000);
  touchtimes = 0;
  document.ontouchstart = myTouchStartHandler;
  document.ontouchend = myTouchEndHandler;
  $('#start-alert')[0].style.display = 'block';
  $('#container')[0].style.marginTop = '0px';
  scrollTo('#container');

}

function timedCount() {
  document.getElementById('timeConsuming').value=c;
  c=c+1;
  yPos_arr.push(window.pageYOffset);
  t=setTimeout("timedCount()",1000);
}

function submitResult(taskType) {
  var name = $('input:text[name=Name]').val();
  document.getElementById('touchtimes').value=touchtimes;
  clearTimeout(t);
  $('input:text[name=Offset]').val(offset_arr.toString());
  $('input:text[name=YPos]').val(yPos_arr.toString());
  $('input:text[name=TouchOnTiming]').val(touchOnTiming.toString());
  $('input:text[name=TouchEndTiming]').val(touchEndTiming.toString());
  $('#myForm')[0].action += '?subject=[HCI_Project]' + name + '-' + taskType;
  $("#myForm").submit();
  $('#end_btn')[0].style.display = 'none';
  $('#end_btn')[0].onclick = null;
  $('#next_task_btn')[0].style.display = 'block';
}
//alert(window.screen.width);
//The following part is for mobile-device screen visibility config
function refreshContactWhenFlip_Fluid() {
  w=document.body.clientWidth;
  //alert(w);
  //alert($('#article')[0].style.fontSize);
  if(w > 600){ // horizontal orientation
    $('#article')[0].style.fontSize = '16px';
    $('#container')[0].style.marginLeft = '16px';
    $('#container')[0].style.marginRight = '16px';
  }
  else if (w < 400) { // vertical orientation
    $('#article')[0].style.fontSize = '16px';
    $('#container')[0].style.marginLeft = '16px';
    $('#container')[0].style.marginRight = '16px';
    //$('#article').show();
  }
}
function refreshContactWhenFlip_Fixed() {
  w=document.body.clientWidth;
  //alert(w);
  //alert($('#article')[0].style.fontSize);
  if(w > 600){ // horizontal orientation
    $('#article')[0].style.fontSize = '29.5px';
    $('#container')[0].style.marginLeft = '25px';
    $('#container')[0].style.marginRight = '25px';
  }
  else if (w < 400) { // vertical orientation
    $('#article')[0].style.fontSize = '16px';
    $('#container')[0].style.marginLeft = '16px';
    $('#container')[0].style.marginRight = '16px';
  }
}


function scrollTo(tar_id) {
  $("body").scrollTop($(tar_id).offset().top - 40);
}

$("body").scrollTop(0);
