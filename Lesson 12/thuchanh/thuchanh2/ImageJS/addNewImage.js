function addNewImage() {

    let image = $("#add-image")[0];
    let formData = new FormData(image);
    $.ajax({
        url : `${pathImage}`,
        enctype: 'multipart/form-data',
        data : formData,
        type : "POST",
        processData: false,
        contentType: false,
        cache : false,
        timeout : 6000000,
        success : function (data) {
            let content = `<img src="http://localhost:8080/image/${data.file}" alt="" width="100" height="100"> `;
            $("#content").html(content);
        }
    })
    event.preventDefault();
}
