def printEnv() {
  sh 'printenv | sort'
}

def printJobParams(Map args = [:]) {
  def output = args.params.sort().collect { name, value ->
    "${name}=${value}"
  }.join('\n')
  echo output
}

def printWorkDir() {
  sh 'pwd && tree'
}