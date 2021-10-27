function deleteSmartphone(id) {
    $.ajax({
        type : "GET",
        url : `${path}/${id}`,
        success : function (data) {
            let content =  `<div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Delete Confirm</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body" >
                                    <div class="card" style="width: 18rem;">
                                        <div class="card-header">
                                            Smartphone Detail
                                        </div>
                                        <ul class="list-group list-group-flush" id="delete-smartphone-detail" >
                                            <input type="hidden" id="smartphone-delete-confirm-id" value="${data.id}">
                                            <li class="list-group-item">${data.producer}</li>
                                            <li class="list-group-item">${data.model}</li>
                                            <li class="list-group-item">${data.price}</li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-primary" onclick="deleteConfirm()" data-bs-dismiss="modal">Delete</button>
                                </div>
                            </div>`

            document.getElementById('modal-content-area').innerHTML = content;
        }
    })
}

function deleteConfirm() {
    let id =  $('#smartphone-delete-confirm-id').val();
    $.ajax({
        type: "DELETE",
        url: `${path}/${id}`,
        success : showAll
    })
}
