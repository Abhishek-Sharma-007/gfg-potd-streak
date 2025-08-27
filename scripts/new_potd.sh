#!/usr/bin/env bash
set -euo pipefail
Y="$1"; MD="$2"; SLUG="$3"
DIR="problems/${Y}/${MD}/${SLUG}"
mkdir -p "$DIR"
echo "# ${SLUG//-/ /}" > "$DIR/README.md"
touch "$DIR/solution.py" "$DIR/Solution.java" "$DIR/solution.js"
echo "- TODO: ${Y}-${MD} ${SLUG}" > "progress/${Y}-${MD}.md"
echo "| ${Y}-${MD} | ${SLUG//-/ /} | ${DIR}/ |" >> README.md

