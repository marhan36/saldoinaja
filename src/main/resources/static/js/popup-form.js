function submitFormAndClosePopup(event) {
    event.preventDefault();
    const form = event.target;
    fetch(form.action, {
        method: 'POST',
        body: new FormData(form)
    }).then(() => {
        // Send message to parent window to close modal and reload
        if (window.parent !== window) {
            window.parent.postMessage('reloadAndClose', '*');
        } else if (window.opener) {
            window.opener.location.reload();
            window.close();
        }
    });
}
