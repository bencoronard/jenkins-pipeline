def convertToKebabCase(String text) {
  return text.replaceAll(' ','-').toLowerCase()
}

def shortenCommitSHA(String commitSHA) {
  return commitSHA.substring(0,7)
}

def covertRefToTag(String ref) {
  def tagRefRegex = /^refs\/tags\/(.+)$/
  def matcher = ref =~ tagRefRegex
  if (matcher.match()) {
    echo "Reference ${ref} is valid"
    return matcher[0][1]
  }
  error "Invalid git tag reference. Expected refs/tag/<tag>, got: ${ref}"
}