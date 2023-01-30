package io.easeci.bash;

import io.easeci.extension.command.Command;
import io.easeci.extension.command.Directive;
import io.easeci.extension.directive.CodeChunk;
import io.easeci.extension.directive.CodeLanguage;

import java.util.Collections;
import java.util.List;

public class BashPerformer implements Directive {

    @Override
    public String getDirectiveName() {
        return "bash";
    }

    @Override
    public List<Command> getAvailableCommandList() throws IllegalAccessException {
        return Collections.emptyList();
    }

    @Override
    public CodeChunk provideCode(String invocationBody) throws IllegalAccessException {
        final String code = "#!/bin/python3\n" +
        "import subprocess\n" +
        "subprocess.check_call(\"" + invocationBody + "\", shell=True)";
        return CodeChunk.of(0, getDirectiveName(), CodeLanguage.PYTHON_3, code, "UTF-8");
    }
}
