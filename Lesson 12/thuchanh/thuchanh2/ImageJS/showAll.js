function showAll() {
    $('img').show();

    $.ajax({
        url : `${pathImage}`,
        type : "GET",
        success : function (result) {
            let content;
            for(i=0; i < result.length ; i++ ) {
                content += `<img src="http://localhost:8080/image/${result[i].file}" alt="" width="100" height="100"> `;
            }

            document.getElementById("new-img").innerHTML = content;
        }
    })
}
function hideAll() {
    $("img").hide()
}

