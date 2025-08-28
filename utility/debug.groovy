def printEnv() {
  sh 'printenv | sort'
}

def printWorkDir() {
  sh 'pwd'
  sh 'ls -laF'
}

return this