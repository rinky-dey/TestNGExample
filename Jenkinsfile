node{
  stage('SCM Checkout'){
    git 'https://github.com/rinky-dey/TestNGExample'
  }
  stage('Compile-Package'){
    sh 'maven package'
  }
}
