#!/bin/bash

#
# Buildscript to build all Android samples using gradle build system.
# by 2014 Taeho Kim <jyte82@gmail.com>
#

# Specify Projects to build
projects=(
	2013-05-22_Android_Studio_First_Project/HelloWorld
	2013-07-21_Navigation_Drawer_Example/NavigationDrawerExample_Studio
	2013-11-18_AndroidStudio_Libproject/AndroidStudioLibApp
	2014-04-07_AndroidStudio_Testing/StudioTesting
	2014-05-12_Signing_with_Android_Studio/SigningWithStudio
	2014-06-01_NavigationDrawer_Fragments/BasicFragments
	2014-06-01_NavigationDrawer_Fragments/BasicFragments_withActionItem
	2014-06-01_NavigationDrawer_Fragments/BasicFragments_PersistState
	2014-11-13_Support_Material
	2014-11-16_Material_Navigation_Drawer
	2014-11-17_Material_Navigation_Drawer_FullOverlay
	2014-11-18_MaterialColor
	2015-01-24_Material_Design_for_everyone
	2015-03-12_SelectableItem_background_compat
	2015-07-12_Support_Design_Sample
	2015-08-04_Coordinator_Layout
	2016-01-18_Support_SelectableItemBackgroud
	2016-02-13_JacocoUnitTest
	2016-02-28_bottom_sheets
	2016-03-08_Hello_Kotlin
	2016-03-16_bottom_navigation_behavior
	2016-03-26_Google_Maps_V2_2016
	2016-07-24_Kotlin_Android_Extensions
	#2016-09-06_ktlint_on_android
)

function build_subprojects(){

	for i in "${projects[@]}"
	do
		:
		echo
		echo [+] Building project $i ...
		echo
		# Move to subproject path
		cd $i
		# Invoke build command
		./gradlew build

		if [ $? -ne 0 ]; then
			echo 
			echo [-] Failed to build project.
			echo
			exit -1
		fi
		cd $ROOT_DIR
	done
}

ROOT_DIR=$(pwd)

build_subprojects

