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

