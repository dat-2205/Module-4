function showCreateForm() {
    let content = `<form id="add-smartphone">
                                <table>
                                    <tr>
                                        <td>Producer:</td>
                                        <td><input type="text" id="producer" placeholder="producer"></td>
                                    </tr>
                                    <tr>
                                        <td>Model:</td>
                                        <td><input type="text" id="model" placeholder="model"></td>
                                    </tr>
                                    <tr>
                                        <td>Price:</td>
                                        <td><input type="text" id="price" placeholder="price"></td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td><input type="submit" value="Add" onclick="addNewSmartPhone()"></td>
                                    </tr>
                                </table>
                            </form>`
    document.getElementById('content').innerHTML = content;
};