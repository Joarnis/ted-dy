
// This example displays an address form, using the autocomplete feature
// of the Google Places API to help users fill in the information.

// This example requires the Places library. Include the libraries=places
// parameter when you first load the API. For example:
//<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">

var placeSearch, autocomplete;
var submit;
var componentForm = {
    street_number: 'short_name',
    route: 'long_name',
    locality: 'long_name',
    sublocality: 'long_name',
    administrative_area_level_1: 'long_name',
    administrative_area_level_2: 'long_name',
    administrative_area_level_3: 'long_name',
    neighborhood: 'long_name',
    premise: 'long_name',
    //administrative_area_level_1: 'short_name',
    country: 'long_name',
    postal_code: 'short_name'
};

function initAutocomplete() {
	// Create the autocomplete object, restricting the search to geographical
	// location types.
    autocomplete = new google.maps.places.Autocomplete(
    /** @type {!HTMLInputElement} */(document.getElementById('locSearch:mainstr')),
    {types: ['geocode']});

    // When the user selects an address from the dropdown, populate the address
    // fields in the form.
    autocomplete.addListener('place_changed', fillInAddress);
    
    // Do not submit form on first enter
    var input = document.getElementById('locSearch:mainstr');
    submit = 0;
    google.maps.event.addDomListener(input, 'keydown', function(event) { 
      if (event.keyCode === 13 && submit == 0) { 
          event.preventDefault();
          submit = 1;
      }
      else
    	  submit = 0;
    });
}

function fillInAddress() {
// Get the place details from the autocomplete object.
    var place = autocomplete.getPlace();
    for(var component in componentForm) {
    	// Add jsf form id
    	plusformid = 'locSearch:' + component;
        document.getElementById(plusformid).value = '';
        document.getElementById(plusformid).disabled = false;
    }
    // Get each component of the address from the place details
    // and fill the corresponding field on the form.
    for (var i = 0; i < place.address_components.length; i++) {
        var addressType = place.address_components[i].types[0];
        if (componentForm[addressType]) {
            var val = place.address_components[i][componentForm[addressType]];
            var plusformid = 'locSearch:' + addressType;
            document.getElementById(plusformid).value = val;
        }
    }
}




     /* // Bias the autocomplete object to the user's geographical location,
      // as supplied by the browser's 'navigator.geolocation' object.
      function geolocate() {
        if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(function(position) {
            var geolocation = {
              lat: position.coords.latitude,
              lng: position.coords.longitude
            };
            var circle = new google.maps.Circle({
              center: geolocation,
              radius: position.coords.accuracy
            });
            autocomplete.setBounds(circle.getBounds());
          });
        }
      }*/
