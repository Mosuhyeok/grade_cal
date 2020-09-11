
$(function(){   // body가 다 읽어지면 실행해지는것  document.ready랑 똑같
    var first = document.getElementById('first_cal');
    first.addEventListener('click',function () {
        window.location.href="/firstFunc";
    },false)

    var second = document.getElementById('second_cal');
    second.addEventListener('click',function () {
        window.location.href="/secondFunc";
    })
});
