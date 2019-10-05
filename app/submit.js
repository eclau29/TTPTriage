'use strict';

const vitals = document.getElementsByName('vitals');
const person = {};
const patients = [];

function displayVitals() {

  vitals.forEach(el => {
    if (el.checked) {
      person.id = Date.now();
      person.initial_eval_time = new Date;
      person.vital_color = el.value;
      // person.gps_location = ;
      person.gender = null;
      person.name = '';
      person.age = 0;
    }
  });

  console.log(person);

  return patients.push(person);
}

// Geolocation Function =================================================

var options = {
  enableHighAccuracy: true,
  timeout: 5000,
  maximumAge: 0
};

function success(pos) {
  var crd = pos.coords;

  console.log('Your current position is:');
  console.log(`Latitude : ${crd.latitude}`);
  console.log(`Longitude: ${crd.longitude}`);
  console.log(`More or less ${crd.accuracy} meters.`);
  person.gps_location = `Latitude : ${crd.latitude} & Longitude: ${crd.longitude}`;
}

function error(err) {
  console.warn(`ERROR(${err.code}): ${err.message}`);
}

navigator.geolocation.getCurrentPosition(success, error, options)