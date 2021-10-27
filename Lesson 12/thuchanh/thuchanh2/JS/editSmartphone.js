function editSmartphone(id) {
    $.ajax ({
        headers: {
            'Accept' : 'application/json',
            'Content-Type' : 'application/json'
        },
        type: "GET",
        url: `${path}/${id}`,
        success: function (result) {
            let content = `<div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Edit SmartPhone</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body" >
                                    <form id="edit-smartphone-form">
                                        <table>
                                            <tr><td><input type="hidden" id="id" value="${result.id}"></td></tr>
                                            <tr>
                                                <td>Producer:</td>
                                                <td><input type="text" id="producer" placeholder="producer" value="${result.producer}"></td>
                                            </tr>
                                            <tr>
                                                <td>Model:</td>
                                                <td><input type="text" id="model" placeholder="model" value="${result.model}"></td>
                                            </tr>
                                            <tr>
                                                <td>Price:</td>
                                                <td><input type="text" id="price" placeholder="price" value="${result.price}"></td>
                                            </tr>
                                        </table>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-primary" data-bs-dismiss="modal" onclick="saveEdit()" >Save</button>
                                </div>
                            </div>`
            document.getElementById('modal-content-area').innerHTML = content;
        }
    })
}

function saveEdit() {
    let id  =  $(`#id`).val();
    let producer = $('#producer').val();
    let model = $('#model').val();
    let price = $('#price').val();

    let newSmartphone = {
        producer: producer,
        model: model,
        price: price
    };

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        data: JSON.stringify(newSmartphone),
        //tên API
        url: `${path}/${id}`,
        //xử lý khi thành công
        success: showAll
    });
    event.preventDefault();
}