package br.com.vedoveto.commandlineparser.args;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static br.com.vedoveto.commandlineparser.args.ArgsException.ErrorCode.INVALID_INTEGER;
import static br.com.vedoveto.commandlineparser.args.ArgsException.ErrorCode.MISSING_INTEGER;

class IntegerArgumentMarshaler implements ArgumentMarshaler<Integer> {
    private int intValue = 0;

    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;
        try {
            parameter = currentArgument.next();
            intValue = Integer.parseInt(parameter);
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_INTEGER);
        } catch (NumberFormatException e) {
            throw new ArgsException(INVALID_INTEGER, parameter);
        }
    }

    public Integer get() {
        return intValue;
    }
}
