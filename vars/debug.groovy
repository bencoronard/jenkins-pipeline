def printEnv() {
  sh 'printenv | sort'
}

def printParams(Map args = [:]) {
  def output = args.params.sort().collect { name, value ->
    "${name}=${value}"
  }.join('\n')
  echo output
}

def printWorkDir() {
  sh 'pwd && tree'
}