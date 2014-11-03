
var touchtimes = 0;
var yOffsetOnTouchStart;
var yOffsetOnTouchEnd;
var offset_arr = [];


function myTouchStartHandler() {
  yOffsetOnTouchStart = window.pageYOffset;
  touchtimes+=1;
  //$('#offsetLogs').val('hi');
}

function myTouchEndHandler() {
  yOffsetOnTouchEnd = window.pageYOffset;
  if(yOffsetOnTouchEnd - yOffsetOnTouchStart != 0) {
    offset_arr.push(yOffsetOnTouchEnd - yOffsetOnTouchStart);
  }
  else {
    touchtimes-=1;
  }
}


var c=0;
var t;

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
  t=setTimeout("timedCount()",1000);
}

function submitResult(taskType) {
  var name = $('input:text[name=Name]').val();
  document.getElementById('touchtimes').value=touchtimes;
  clearTimeout(t);
  $('input:text[name=Offset]').val(offset_arr.toString());
  $('#myForm')[0].action += '?subject=[HCI_Project]' + name + '-' + taskType;
  $("#myForm").submit();
}
//alert(window.screen.width);
//The following part is for mobile-device screen visibility config
function refreshContactWhenFlip_Fluid() {
  w=document.body.clientWidth;
  //alert(w);
  //alert($('#article')[0].style.fontSize);
  if(w > 600){ // horizontal orientation
    $('#article')[0].style.fontSize = '16px';
  }
  else if (w < 400) { // vertical orientation
    $('#article')[0].style.fontSize = '16px';
    //$('#article').show();
  }
}
function refreshContactWhenFlip_Fixed() {
  w=document.body.clientWidth;
  //alert(w);
  //alert($('#article')[0].style.fontSize);
  if(w > 600){ // horizontal orientation
    $('#article')[0].style.fontSize = '28px';
    $('#container')[0].style.marginLeft = '10px';
    $('#container')[0].style.marginRight = '10px';
  }
  else if (w < 400) { // vertical orientation
    $('#article')[0].style.fontSize = '16px';
    //$('#article').show();
  }
}


function scrollTo(tar_id) {
  $("body").scrollTop($(tar_id).offset().top - 40);
}

$("body").scrollTop(0);
