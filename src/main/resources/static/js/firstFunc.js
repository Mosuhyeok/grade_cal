$(function () {
    // 클릭시 성적입력공간 더 늘리는 js코드
    $("#btn-add").click(function(){
        $('#table').append('<tr><td><select name="grade"><option value="학점">학점</option><option value="4.5">A+</option><option value="4.0">A0</option><option value="3.5">B+</option><option value="3.0">B0</option><option value="2.5">C+</option><option value="2.0">C0</option><option value="1.5">D+</option><option value="1.0">D0</option><option value="0.0">F</option></select></td><td><input type="text" name="score"></td><td><input type="checkbox" name="major"></td></tr>')
    })

    $("#btn-submit").click(function () {
        var gradeLen = $('select[name="grade"]').length;
        var gradeArr =[];

        var scoreLen = $('input[name=score]').length;
        var scoreArr = [];

        for(var i=0; i<gradeLen; i++){
            gradeArr.push($('select[name="grade"]').eq(i).val());
        }


        for(var i=0; i<scoreLen; i++){
            scoreArr.push($('input[name=score]').eq(i).val());
        }


        var data = [];

        for(var i=0; i<gradeLen; i++){
            var obj = {
                "grade" : gradeArr[i],
                "score" : scoreArr[i]
            }
            data.push(obj);
        }

        $.ajax({
            type: 'POST',
            url : '/result',
            dataType : 'json',
            contentType :'application/json ; charset=utf-8',
            data : JSON.stringify(data),
        }).done(function (json) {
            $('#totalGrade').text(json.totalGrade);
            $('#totalScore').text(json.totalScore);
            $('.cal_result').css("display","inline");

        }).fail(function (error) {
            alert("모든 항목을 입력해주세요");
        });
    })
})
