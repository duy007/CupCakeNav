/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.cupcake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.cupcake.ui.theme.CupcakeTheme

/**
 * Activity for cupcake order flow.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CupcakeTheme {
                CupcakeApp()
            }
        }
    }
}

/**
 * The Navigation component has three main parts:

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
** NavHostController is a subclass of the NavController class that provides additional
* functionality for use with a NavHost composable.

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

a user interface component that covers the bottom part of the screen—that shows sharing options.

This piece of UI isn't part of the Cupcake app. In fact, it's provided by the Android
operating system.
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
 */