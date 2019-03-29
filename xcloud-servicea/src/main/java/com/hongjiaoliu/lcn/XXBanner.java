package com.hongjiaoliu.lcn;

import org.springframework.boot.Banner;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

/**
 * @author liuhongjao
 * @date 2019/3/29 13:47
 */

public class XXBanner implements Banner {

	private static final String BANNER =
			"#     # #     # ####### #     # ### #     # \n" +
			" #   #  #     # #        #   #   #  ##    # \n" +
			"  # #   #     # #         # #    #  # #   # \n" +
			"   #    #     # #####      #     #  #  #  # \n" +
			"  # #   #     # #         # #    #  #   # # \n" +
			" #   #  #     # #        #   #   #  #    ## \n" +
			"#     #  #####  ####### #     # ### #     # \n";

	@Override
	public void printBanner(Environment environment, Class<?> sourceClass, PrintStream printStream) {
		printStream.println();
		printStream.println(AnsiOutput.toString(AnsiColor.GREEN, BANNER));
		printStream.println();
	}
}
