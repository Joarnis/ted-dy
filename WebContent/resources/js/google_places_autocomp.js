
// This example displays an address form, using the autocomplete feature
// of the Google Places API to help users fill in the information.

// This example requires the Places library. Include the libraries=places
// parameter when you first load the API. For example:
//<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">

var placeSearch, autocomplete;
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
    /*var input = document.getElementById('locSearch:mainstr');
    google.maps.event.addDomListener(input, 'keydown', function(event) { 
      if (event.keyCode === 13) { 
          event.preventDefault(); 
      }
    });*/
    
    
    /*var location_being_changed,
    	onPlaceChange = function () {
        	location_being_changed = false;
    	};
    
    autocomplete.addListener('place_changed', onPlaceChange);
    
    google.maps.event.addDomListener(input, 'keydown', function (e) {
        if (e.keyCode === 13) {
            if (location_being_changed) {
                e.preventDefault();
                e.stopPropagation();
            }
        } else {
            // means the user is probably typing
            location_being_changed = true;
        }
    });
    
    google.maps.event.addDomListener(input, 'keydown', function (e) {
    	// If it's Enter
    	if (e.keyCode === 13) {
    		// Select all Google's dropdown DOM nodes (can be multiple)
    	    var googleDOMNodes = document.getElementsByClassName('pac-container');
    	    // Check if any of them is visible (using ES6 here for conciseness)
    	    var googleDOMNodeIsVisible = Array.from(googleDOMNodes).some(function (node) { 
    	    	return node.offsetParent != null;
    	    });
    	    // If it's so - preventDefault
    	    if (googleDOMNodeIsVisible)
    	    	e.preventDefault();
    	}
    });*/
    
    
    google.maps.event.addDomListener(
    	    document.getElementById('locSearch:mainstr'),
    	    'keydown',
    	    function(e) {
    	          // If it's Enter
    	          if (e.keyCode === 13) {
    	            // Select all Google's dropdown DOM nodes (can be multiple)
    	            var googleDOMNodes = document.getElementsByClassName('pac-container');
    	            //If multiple nodes, prevent form submit.
    	            if (googleDOMNodes.length > 0){
    	                e.preventDefault();
    	            }
    	            //Remove Google's drop down elements, so that future form submit requests work.
    	            removeElementsByClass('pac-container');
    	          }
    	    }
    	);

    	function removeElementsByClass(className){
    	    var elements = document.getElementsByClassName(className);
    	    while(elements.length > 0){
    	        elements[0].parentNode.removeChild(elements[0]);
    	    }
    	}
    /*autocomplete.addListener('keydown', function(e) { 
        if (e.keyCode == 13 && $('.pac-container:visible').length) { 
            e.preventDefault(); 
        }
    });*/
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
