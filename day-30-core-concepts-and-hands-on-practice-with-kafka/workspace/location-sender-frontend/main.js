console.log('main.js loaded.');

var intervalId;

function sendCurrentLocation() {
  navigator.geolocation.getCurrentPosition(successHandler, errorHandler);
}

function successHandler(pos) {
  const {
    coords: { latitude, longitude },
  } = pos;
  console.log(latitude, longitude);
  const logDiv = document.querySelector('#log');

  fetch('http://localhost:5678/api/location', {
    method: 'POST',
    body: JSON.stringify({ latitude, longitude }),
    headers: {
      'Content-Type': 'application/json',
    },
  })
    .then(() => {
      logDiv.innerHTML += `<p>sent location (${latitude}, ${longitude})</p>`;
    })
    .catch((err) => {
      logDiv.innerHTML += `<p>something went wrong. please check console logs</p>`;
      console.log(err);
    });
}

function errorHandler(err) {
  console.log(err);
}

document.querySelector('#btnSendLoc').onclick = function () {
  const logDiv = document.querySelector('#log');
  logDiv.innerHTML += `<p>Started sending location</p>`;
  intervalId = setInterval(sendCurrentLocation, 1000);
};

document.querySelector('#btnCancelSendLoc').onclick = function () {
  clearInterval(intervalId);
  const logDiv = document.querySelector('#log');
  logDiv.innerHTML += `<p>Stopped sending location</p>`;
};
