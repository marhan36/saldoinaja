function submitFormAndClosePopup(event) {
    event.preventDefault();
    const form = event.target;
    fetch(form.action, {
        method: 'POST',
        body: new FormData(form)
    }).then(() => {
        if (window.opener) window.opener.location.reload();
        window.close();
    });
}
