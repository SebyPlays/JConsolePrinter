# JConsolePrinter
This is an advanced version of the "System.output.println();" method including colorcodes supported by the JANSI api.

## Work
The API only works under Windows in the Windows CMD, PowerShell and IDEs that return null for System.console().
Otherwise the API works in all command lines that support Ansi escape codes.


## Usage
```Java
ConsolePrinter.print(String text, boolean colored, boolean date, boolean time);
```

## Style-Codes
he Style-Codes can be used within the string. If the boolean "colorize" is true, the codes will be replaced by the function.

| Code |             Style              | Ansi Escape Code |
|:----:|:------------------------------:|:----------------:|
|  §f0 |        Forground-Black         |        30        |
|  §f1 |         Forground-Blue         |        34        |
|  §f2 |        Forground-Green         |        32        |
|  §f3 |         Forground-Cyan         |        36        |
|  §f4 |         Forground-Red          |        31        |
|  §f5 |       Forground-Magenta        |        35        |
|  §f6 |        Forground-Yellow        |        33        |
|  §f7 |        Forground-White         |        37        |
|  §f8 | Forground-Bright Black (Gray)  |        90        |
|  §f9 |     Forground-Bright Blue      |        94        |
|  §fa |     Forground-Bright Green     |        92        |
|  §fb |     Forground-Bright Cyan      |        96        |
|  §fc |      Forground-Bright Red      |        91        |
|  §fd |    Forground-Bright Magenta    |        95        |
|  §fe |    Forground-Bright Yellow     |        93        |
|  §ff |     Forground-Bright White     |        97        |
|      |                                |                  |
|  §b0 |        Background-Black        |        30        |
|  §b1 |         Background-Blue        |        34        |
|  §b2 |        Background-Green        |        32        |
|  §b3 |         Background-Cyan        |        36        |
|  §b4 |         Background-Red         |        31        |
|  §b5 |       Background-Magenta       |        35        |
|  §b6 |        Background-Yellow       |        33        |
|  §b7 |        Background-White        |        37        |
|  §b8 | Background-Bright Black (Gray) |        90        |
|  §b9 |     Background-Bright Blue     |        94        |
|  §ba |     Background-Bright Green    |        92        |
|  §bb |     Background-Bright Cyan     |        96        |
|  §bc |      Background-Bright Red     |        91        |
|  §bd |    Background-Bright Magenta   |        95        |
|  §be |    Background-Bright Yellow    |        93        |
|  §bf |     Background-Bright White    |        97        |
|      |                                |                  |
|  §eb |              Bold              |         1        |
|  §eu |           Underline            |         4        |
|      |                                |                  |
|  §r  |             Reset              |         0        |
