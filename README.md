# CupCakeNav

The Navigation component has three main parts:
NavController: Responsible for navigating between destinations—that is, the screens in your app.
NavGraph: Maps composable destinations to navigate to.
NavHost: Composable acting as a container for displaying the current destination of the NavGraph.
One of the fundamental concepts of navigation in a Compose app is the route.

A route is a string that corresponds to a destination.
A destination is typically a single Composable or group of Composables corresponding to
what the user sees.

A NavHost is a Composable that displays other composable destinations, based on a given route.
For example, if the route is Flavor, then the NavHost would show the screen to choose the cupcake
flavor. If the route is Summary, then the app displays the summary screen.
NavHost (navController, startDestination, modifier) { content }

navController: An instance of the NavHostController class. You can use
this object to navigate between screens, for example, by calling the navigate()
method to navigate to another destination. You can obtain the NavHostController by
calling rememberNavController() from a composable function.

NavHostController is a subclass of the NavController class that provides additional
functionality for use with a NavHost composable.

startDestination: A string route defining the destination shown by default when the app first
displays the NavHost. In the case of the Cupcake app, this should be the Start route.
Within the content function of a NavHost, you call the composable() function.
The composable() function has two required parameters.

route: A string corresponding to the name of a route. This can be any unique string.
You'll use the name property of the CupcakeScreen enum's constants.
content: Here you can call a composable that you want to display for the given route.
To navigate to another route, simply call the navigate() method on your instance of
NavHostController.

The navigate method takes a single parameter: a string corresponding to a route
defined in your NavHost. If the route matches one of the calls to composable() in
the NavHost, the app then navigates to that screen.

Now that you've defined your routes and mapped them to composables in a NavHost, it's time to navigate between screens. T
he NavHostController—the navController property from calling rememberNavController()—is responsible for navigating between routes. 
Notice, however, that this property is defined in the CupcakeApp composable. You need a way to access it from the different screens in your app.

Easy, right? Just pass the navController as a parameter to each of the composables.

While this approach works, it's not an ideal way to architect your app. A benefit of using a NavHost to handle your app's navigation is
that navigation logic is kept separate from individual UI. This option avoids some of the major drawbacks of passing the navController as a parameter.

Navigation logic is kept in one place, which can make your code easier to maintain and prevent bugs by not accidentally giving individual screens free reign of navigation in your app.
In apps that need to work on different form factors (like portrait mode phone, foldable phone, or large screen tablet), a button may or may not trigger navigation, depending on the app's layout. Individual screens should be self-contained and don't need to be aware of other screens in the app.

take a look at the type of quantityOptions parameter.

The type is List<Pair<Int, Int>> or a list of Pair<Int, Int>. The Pair type may be unfamiliar to you, but it's just as the name suggests, a pair of values. Pair takes two generic type parameters. In this case, they're both of type Int.

a user interface component that covers the bottom part of the screen—that shows sharing options.
This piece of UI isn't part of the Cupcake app. In fact, it's provided by the Android
operating system.

Unlike the system back button, the Cancel button doesn't go back to the previous screen. Instead, it should pop—remove—all screens from the backstack and return to the starting screen.

You can do this by calling the popBackStack() method.

2f382e5eb319b4b8.png

The popBackStack() method has two required parameters.

route: The string representing the route of the destination you want to navigate back to.
inclusive: A Boolean value that, if true, also pops (removes) the specified route. If false, popBackStack() will remove all destinations on top of—but not including—the start destination, leaving it as the topmost screen visible to the user.
When users press the Cancel button on any of the screens, the app resets the state in the view model and calls popBackStack()

System UI, such as the sharing screen, isn't called by your navController.
Instead, you use something called an Intent.

a user interface component that covers the bottom part of the screen—that shows sharing options.
An intent is a request for the system to perform some action, commonly presenting a new activity.
There are many different intents, and you're encouraged to refer to the documentation for a
comprehensive list. However, we are interested in the one called ACTION_SEND. You can supply
this intent with some data, such as a string, and present appropriate sharing actions for that data.
The basic process for setting up an intent is as follows:

Create an intent object and specify the intent, such as ACTION_SEND.
Specify the type of additional data being sent with the intent.

For a simple piece of text, you can use "text/plain", though other types, such as
"image/*" or "video/*", are available.

Pass any additional data to the intent, such as the text or image to share,
by calling the putExtra() method. This intent will take two extras: EXTRA_SUBJECT and EXTRA_TEXT.
Call the startActivity() method of context, passing in an activity created from the intent.
