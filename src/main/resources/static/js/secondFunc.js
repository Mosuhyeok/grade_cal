$(function () {
    alert("hi");
    $('#secondSubmit').click(function () {
        var allScore = $('#allScore').val();    //총 학점
        var allGrade = $('#allGrade').val();    //총 평균
        var nowScore = $('#nowScore').val();    //이번 수강학점
        var nowGrade = $('#nowGrade').val();    //목표 학점

        var data ={
            allScore : allScore,
            allGrade : allGrade,
            nowScore : nowScore,
            nowGrade : nowGrade
        }
        console.log(JSON.stringify(data));
        $.ajax({
            type : 'POST',
            url : '/secondResult',
            dataType : 'text',
            contentType : 'application/json ; charset=utf-8',
            data : JSON.stringify(data),
        }).done(function (json) {
            $('#secondResult').text(json);
            $('.second_result').css("display","inline");
        }).fail(function (error) {
            alert("error");
        });
    })
})
