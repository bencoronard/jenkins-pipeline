def call(Map args = [:]) {
  def content = libraryResource "dev/hireben/cicd/script/${args.file}"
  writeFile file: args.file, text: content
  sh "chmod +x ${args.file} && ./${args.file} ${args.arg}"
}