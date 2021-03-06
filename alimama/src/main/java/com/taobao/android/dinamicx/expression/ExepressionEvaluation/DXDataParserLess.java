package com.taobao.android.dinamicx.expression.ExepressionEvaluation;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.DXAbsDinamicDataParser;
import com.taobao.android.dinamicx.expression.utils.DXNumCompareUtils;

public class DXDataParserLess extends DXAbsDinamicDataParser {
    public static final long DX_PARSER_LESS = 35869474411L;

    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        return DXNumCompareUtils.evalWithArgs(objArr, 2);
    }
}
