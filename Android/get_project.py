"""
Copyright 2014 Taeho Kim <jyte82@gmail.com>

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
"""

import sys, os

REPO_BASE_URL='https://github.com/kunny/blog_samples/trunk/Android/'

class Project:
	name = None
	path = None
	postUrl = None

	def __init__(self, projName, projPath, projPostUrl):
		self.name = projName
		self.path = projPath
		self.postUrl = projPostUrl
		return

projects = [
	Project('HelloWorld', 
		'2013-05-22_Android_Studio_First_Project/HelloWorld', 
		'None'),
	Project('NavigationDrawerExample_Studio', 
		'2013-07-21_Navigation_Drawer_Example/NavigationDrawerExample_Studio', 
		'http://androidhuman.com/524'),
	Project('AndroidStudioLibApp', 
		'2013-11-18_AndroidStudio_Libproject/AndroidStudioLibApp', 
		'http://androidhuman.com/530'),
	Project('StudioTesting',
		'2014-04-07_AndroidStudio_Testing/StudioTesting',
		'http://androidhuman.com/536'),
	Project('SigningWithStudio',
		'2014-05-12_Signing_with_Android_Studio/SigningWithStudio',
		'http://androidhuman.com/544'),
	Project('BasicFragments',
		'2014-06-01_NavigationDrawer_Fragments/BasicFragments',
		'http://androidhuman.com/546'),
	Project('BasicFragments_withActionItem',
		'2014-06-01_NavigationDrawer_Fragments/BasicFragments_withActionItem',
		'http://androidhuman.com/547'),
	Project('BasicFragments_PersistState',
		'2014-06-01_NavigationDrawer_Fragments/BasicFragments_PersistState',
		'http://androidhuman.com/549'),
	Project('SupportMaterial',
		'2014-11-13_Support_Material',
		'http://androidhuman.com/558')
]

def printProjects():
	print ''
	print 'Available projects : '
	print ''
	sys.stdout.write("%-30s %-40s\n" % ('Name', 'Post URL'))
	print '-----------------------------------------------------------'
	for e in projects:
		sys.stdout.write("%-30s %-40s\n" % (e.name, e.postUrl))
	print ''

def usage(scriptName):
	print ''
	print 'Usage : python ' + scriptName + ' [projectName ...]'
	print 'Example : '
	print '$ python ' + scriptName + ' HelloWorld // Download one project'
	print '$ python ' + scriptName + ' HelloWorld StudioTesting // Download multiple project'
	printProjects();
	return

if len(sys.argv)==1:
	usage(sys.argv[0])
else:
	for i, e in enumerate(sys.argv):
		# Skip first argument (filename)
		if(i==0):
			continue
		for j, p in enumerate(projects):
			if e==p.name:
				print 'Downloading '+p.name+'...'
				os.system('svn checkout '+REPO_BASE_URL+p.path)
				print ''
				break
		if j==len(projects)-1:
			print 'No project found for :'+e
			sys.exit(-1)

