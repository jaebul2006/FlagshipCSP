<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>KVRF</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="./KVRF/chartist-js-master/dist/chartist.min.css">
<script src="./KVRF/chartist-js-master/dist/chartist.min.js"></script>
</head>
<body style="background-color: gray;">	

<div id="container" style="position:absolute; width:100%; height:100%;">
	<div class="ct-chart ct-golden-section" id="chart1" style="width:30%; height:30%;"></div>
	<div class="ct-chart ct-golden-section" id="chart2" style="width:30%; height:30%; top:-30%; left:40%;"></div>
	<div class="ct-chart ct-golden-section" id="chart3" style="width:30%; height:30%;"></div>
	<div class="ct-chart ct-golden-section" id="chart4" style="width:30%; height:30%;"></div>
</div>
	
	<script>
	  // Initialize a Line chart in the container with the ID chart1
	  new Chartist.Line('#chart1', {
	    labels: [1, 2, 3, 4],
	    series: [[100, 120, 180, 200]]
	  });
	
	  // Initialize a Line chart in the container with the ID chart2
	  new Chartist.Bar('#chart2', {
	    labels: [1, 2, 3, 4],
	    series: [[5, 2, 8, 3]]
	  });
	  
	  var chart = new Chartist.Line('#chart3', {
		  labels: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'],
		  series: [
		    [12, 9, 7, 8, 5, 4, 6, 2, 3, 3, 4, 6],
		    [4,  5, 3, 7, 3, 5, 5, 3, 4, 4, 5, 5],
		    [5,  3, 4, 5, 6, 3, 3, 4, 5, 6, 3, 4],
		    [3,  4, 5, 6, 7, 6, 4, 5, 6, 7, 6, 3]
		  ]
		}, {
		  low: 0
		});

		// Let's put a sequence number aside so we can use it in the event callbacks
		var seq = 0,
		  delays = 80,
		  durations = 500;

		// Once the chart is fully created we reset the sequence
		chart.on('created', function() {
		  seq = 0;
		});

		// On each drawn element by Chartist we use the Chartist.Svg API to trigger SMIL animations
		chart.on('draw', function(data) {
		  seq++;

		  if(data.type === 'line') {
		    // If the drawn element is a line we do a simple opacity fade in. This could also be achieved using CSS3 animations.
		    data.element.animate({
		      opacity: {
		        // The delay when we like to start the animation
		        begin: seq * delays + 1000,
		        // Duration of the animation
		        dur: durations,
		        // The value where the animation should start
		        from: 0,
		        // The value where it should end
		        to: 1
		      }
		    });
		  } else if(data.type === 'label' && data.axis === 'x') {
		    data.element.animate({
		      y: {
		        begin: seq * delays,
		        dur: durations,
		        from: data.y + 100,
		        to: data.y,
		        // We can specify an easing function from Chartist.Svg.Easing
		        easing: 'easeOutQuart'
		      }
		    });
		  } else if(data.type === 'label' && data.axis === 'y') {
		    data.element.animate({
		      x: {
		        begin: seq * delays,
		        dur: durations,
		        from: data.x - 100,
		        to: data.x,
		        easing: 'easeOutQuart'
		      }
		    });
		  } else if(data.type === 'point') {
		    data.element.animate({
		      x1: {
		        begin: seq * delays,
		        dur: durations,
		        from: data.x - 10,
		        to: data.x,
		        easing: 'easeOutQuart'
		      },
		      x2: {
		        begin: seq * delays,
		        dur: durations,
		        from: data.x - 10,
		        to: data.x,
		        easing: 'easeOutQuart'
		      },
		      opacity: {
		        begin: seq * delays,
		        dur: durations,
		        from: 0,
		        to: 1,
		        easing: 'easeOutQuart'
		      }
		    });
		  } else if(data.type === 'grid') {
		    // Using data.axis we get x or y which we can use to construct our animation definition objects
		    var pos1Animation = {
		      begin: seq * delays,
		      dur: durations,
		      from: data[data.axis.units.pos + '1'] - 30,
		      to: data[data.axis.units.pos + '1'],
		      easing: 'easeOutQuart'
		    };

		    var pos2Animation = {
		      begin: seq * delays,
		      dur: durations,
		      from: data[data.axis.units.pos + '2'] - 100,
		      to: data[data.axis.units.pos + '2'],
		      easing: 'easeOutQuart'
		    };

		    var animations = {};
		    animations[data.axis.units.pos + '1'] = pos1Animation;
		    animations[data.axis.units.pos + '2'] = pos2Animation;
		    animations['opacity'] = {
		      begin: seq * delays,
		      dur: durations,
		      from: 0,
		      to: 1,
		      easing: 'easeOutQuart'
		    };

		    data.element.animate(animations);
		  }
		});

		// For the sake of the example we update the chart every time it's created with a delay of 10 seconds
		chart.on('created', function() {
		  if(window.__exampleAnimateTimeout) {
		    clearTimeout(window.__exampleAnimateTimeout);
		    window.__exampleAnimateTimeout = null;
		  }
		  window.__exampleAnimateTimeout = setTimeout(chart.update.bind(chart), 12000);
		});
		
		var chart2 = new Chartist.Pie('#chart4', {
			  series: [10, 20, 50, 20, 5, 50, 15],
			  labels: [1, 2, 3, 4, 5, 6, 7]
			}, {
			  donut: true,
			  showLabel: false
			});

			chart2.on('draw', function(data) {
			  if(data.type === 'slice') {
			    // Get the total path length in order to use for dash array animation
			    var pathLength = data.element._node.getTotalLength();

			    // Set a dasharray that matches the path length as prerequisite to animate dashoffset
			    data.element.attr({
			      'stroke-dasharray': pathLength + 'px ' + pathLength + 'px'
			    });

			    // Create animation definition while also assigning an ID to the animation for later sync usage
			    var animationDefinition = {
			      'stroke-dashoffset': {
			        id: 'anim' + data.index,
			        dur: 1000,
			        from: -pathLength + 'px',
			        to:  '0px',
			        easing: Chartist.Svg.Easing.easeOutQuint,
			        // We need to use `fill: 'freeze'` otherwise our animation will fall back to initial (not visible)
			        fill: 'freeze'
			      }
			    };

			    // If this was not the first slice, we need to time the animation so that it uses the end sync event of the previous animation
			    if(data.index !== 0) {
			      animationDefinition['stroke-dashoffset'].begin = 'anim' + (data.index - 1) + '.end';
			    }

			    // We need to set an initial value before the animation starts as we are not in guided mode which would do that for us
			    data.element.attr({
			      'stroke-dashoffset': -pathLength + 'px'
			    });

			    // We can't use guided mode as the animations need to rely on setting begin manually
			    // See http://gionkunz.github.io/chartist-js/api-documentation.html#chartistsvg-function-animate
			    data.element.animate(animationDefinition, false);
			  }
			});

			// For the sake of the example we update the chart every time it's created with a delay of 8 seconds
			chart2.on('created', function() {
			  if(window.__anim21278907124) {
			    clearTimeout(window.__anim21278907124);
			    window.__anim21278907124 = null;
			  }
			  window.__anim21278907124 = setTimeout(chart2.update.bind(chart2), 10000);
			});
	</script>	
</body>
</html>