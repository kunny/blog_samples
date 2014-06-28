# Blog samples [![Build Status](https://travis-ci.org/kunny/blog_samples.svg?branch=master)](https://travis-ci.org/kunny/blog_samples)


블로그 [커니의 안드로이드 이야기](http://androidhuman.com)에 게재되는 포스트에서 사용한 예제를 제공합니다.

## 예제 프로젝트를 다운로드 하려면?
### git을 사용하여 전체 저장소 다운로드

`Github` 애플리케이션을 사용거나, 터미널에서 다음 명령어를 사용하면 전체 저장소를 다운로드 할 수 있습니다.

    $ git clone https://github.com/kunny/blog_samples


### 개별 프로젝트 다운로드

[파이썬 스크립트](https://raw.githubusercontent.com/kunny/blog_samples/master/Android/get_project.py)를 사용하면 일부 프로젝트만 선택하여 다운로드 할 수 있습니다. 스크립트 사용을 위해 미리 설치되어 있어야 하는 구성요소는 다음과 같습니다.

- Python 2.7.5 이상
- Subversion

#### 다운로드 가능한 프로젝트 조회

`python get_project.py` 를 실행하면 스크립트 사용 방법과 함께 다운로드 가능한 프로젝트 정보가 표시됩니다.

	$ python get_project.py

	Usage : python get_project.py [projectName ...]
	Example :
	$ python get_project.py HelloWorld // Download one project
	$ python get_project.py HelloWorld StudioTesting // Download multiple project

	Available projects :

	Name                           Post URL
	-----------------------------------------------------------
	HelloWorld                     None
	NavigationDrawerExample_Studio http://androidhuman.com/524
	AndroidStudioLibApp            http://androidhuman.com/530
	StudioTesting                  http://androidhuman.com/536
	SigningWithStudio              http://androidhuman.com/544
	BasicFragments                 http://androidhuman.com/546
	BasicFragments_withActionItem  http://androidhuman.com/547
	BasicFragments_PersistState    http://androidhuman.com/549

#### 프로젝트 다운로드

원하는 프로젝트를 한 개 혹은 여러 개 동시에 다운로드 할 수 있습니다. 한 개의 프로젝트를 다운로드하려면 다음과 같이 프로젝트 이름을 인자로 적어주면 됩니다.

    $ python get_project.py HelloWorld

여러 프로젝트를 동시에 다운로드 하려는 경우, 인자에 프로젝트 이름들을 연달아 입력하면 됩니다.  
아래는 `HelloWorld` 예제와 `BasicFragments` 예제를 다운로드 하는 예를 보여줍니다.

    $ python get_project.py HelloWorld BasicFragments



