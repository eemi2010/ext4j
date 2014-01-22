/**
 Ext4j UI Library
 Copyright 2014, Alain Ekambi, and individual contributors as indicated
 by the @authors tag. See the copyright.txt in the distribution for a
 full listing of individual contributors.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.eemi.ext4j.client.laf;

/**
 * CSS color names
 * 
 * @see <a href="http://www.w3.org/TR/css3-color/">CSS Color Module Level 3</a>
 * 
 */
public enum Color {
    ALICEBLUE("#f0f8ff", 240, 248, 255), ANTIQUEWHITE("#faebd7", 250, 235, 215), AQUA("#00ffff", 0, 255, 255), AQUAMARINE(
                    "#7fffd4", 127, 255, 212), AZURE("#f0ffff", 240, 255, 255), //
    BEIGE("#f5f5dc", 245, 245, 220), //
    BISQUE("#ffe4c4", 255, 228, 196), //
    BLACK("#000000", 0, 0, 0), //
    BLANCHEDALMOND("#ffebcd", 255, 235, 205), //
    BLUE("blue", 0, 0, 255), // #0000ff
    BLUEVIOLET("#8a2be2", 138, 43, 226), //
    BROWN("brown", 165, 42, 42), // #a52a2a
    BURLYWOOD("#deb887", 222, 184, 135), //
    CADETBLUE("#5f9ea0", 95, 158, 160), //
    CHARTREUSE("#7fff00", 127, 255, 0), //
    CHOCOLATE("#d2691e", 210, 105, 30), //
    CORAL("#ff7f50", 255, 127, 80), //
    CORNFLOWERBLUE("#6495ed", 100, 149, 237), //
    CORNSILK("#fff8dc", 255, 248, 220), //
    CRIMSON("#dc143c", 220, 20, 60), //
    CYAN("#00ffff", 0, 255, 255), //
    DARKBLUE("#00008b", 0, 0, 139), //
    DARKCYAN("#008b8b", 0, 139, 139), //
    DARKGOLDENROD("#b8860b", 184, 134, 11), //
    DARKGRAY("#a9a9a9", 169, 169, 169), //
    DARKGREEN("#006400", 0, 100, 0), //
    DARKGREY("#a9a9a9", 169, 169, 169), //
    DARKKHAKI("#bdb76b", 189, 183, 107), //
    DARKMAGENTA("#8b008b", 139, 0, 139), //
    DARKOLIVEGREEN("darkolivegreen", 85, 107, 47), //
    DARKORANGE("##ff8c00", 255, 140, 0), //
    DARKORCHID("#9932cc", 153, 50, 204), //
    DARKRED("#8b0000", 139, 0, 0), //
    DARKSALMON("#e9967a", 233, 150, 122), //
    DARKSEAGREEN("#8fbc8f", 143, 188, 143), //
    DARKSLATEBLUE("#483d8b", 72, 61, 139), //
    DARKSLATEGRAY("#2f4f4f", 47, 79, 79), //
    DARKSLATEGREY("#2f4f4f", 47, 79, 79), //
    DARKTURQUOISE("#00ced1", 0, 206, 209), //
    DARKVIOLET("#9400d3", 148, 0, 211), //
    DEEPPINK("#ff1493", 255, 20, 147), //
    DEEPSKYBLUE("#00bfff", 0, 191, 255), //
    DIMGRAY("#696969", 105, 105, 105), //
    DIMGREY(" #696969", 105, 105, 105), //
    DODGERBLUE("#1e90ff", 30, 144, 255), //
    FIREBRICK("#b22222", 178, 34, 34), //
    FLORALWHITE("#fffaf0", 255, 250, 240), //
    FORESTGREEN("#228b22", 34, 139, 34), //
    FUCHSIA("#ff00ff", 255, 0, 255), //
    GAINSBORO("#dcdcdc", 220, 220, 220), //
    GHOSTWHITE("#f8f8ff", 248, 248, 255), //
    GOLD("#ffd700", 255, 215, 0), //
    GOLDENROD("#daa520", 218, 165, 32), //
    GRAY("#808080", 128, 128, 128), //
    GREEN("#008000", 0, 128, 0), //
    GREENYELLOW("#adff2f", 173, 255, 47), //
    GREY("#808080", 128, 128, 128), //
    HONEYDEW(" #f0fff0", 240, 255, 240), //
    HOTPINK("#ff69b4", 255, 105, 180), //
    INDIANRED(" #cd5c5c", 205, 92, 92), //
    INDIGO("#4b0082", 75, 0, 130), //
    IVORY("#fffff0", 255, 255, 240), //
    KHAKI("#f0e68c", 240, 230, 140), //
    LAVENDER("#e6e6fa", 230, 230, 250), //
    LAVENDERBLUSH("#fff0f5", 255, 240, 245), //
    LAWNGREEN("#7cfc00", 124, 252, 0), //
    LEMONCHIFFON("#fffacd", 255, 250, 205), //
    LIGHTBLUE("#add8e6", 173, 216, 230), //
    LIGHTCORAL("#f08080", 240, 128, 128), //
    LIGHTCYAN(" #e0ffff", 224, 255, 255), //
    LIGHTGOLDENRODYELLOW("#fafad2", 250, 250, 210), //
    LIGHTGRAY("#d3d3d3", 211, 211, 211), //
    LIGHTGREEN("#90ee90", 144, 238, 144), //
    LIGHTGREY("#d3d3d3", 211, 211, 211), //
    LIGHTPINK("#ffb6c1", 255, 182, 193), //
    LIGHTSALMON("#ffa07a", 255, 160, 122), //
    LIGHTSEAGREEN("#20b2aa", 32, 178, 170), //
    LIGHTSKYBLUE("#87cefa", 135, 206, 250), //
    LIGHTSLATEGRAY("#778899", 119, 136, 153), //
    LIGHTSLATEGREY("#778899", 119, 136, 153), //
    LIGHTSTEELBLUE("#b0c4de", 176, 196, 222), //
    LIGHTYELLOW("#ffffe0", 255, 255, 224), //
    LIME("#00ff00", 0, 255, 0), //
    LIMEGREEN("#32cd32", 50, 205, 50), //
    LINEN("#faf0e6", 250, 240, 230), //
    MAGENTA("#FF00FF", 255, 0, 255), //
    MAROON("#800000", 128, 0, 0), //
    MEDIUMAQUAMARINE("#66cdaa", 102, 205, 170), //
    MEDIUMBLUE("#0000cd", 0, 0, 205), //
    MEDIUMORCHID("#ba55d3", 186, 85, 211), //
    MEDIUMPURPLE("#9370db", 147, 112, 219), //
    MEDIUMSEAGREEN("#3cb371", 60, 179, 113), //
    MEDIUMSLATEBLUE("#7b68ee", 123, 104, 238), //
    MEDIUMSPRINGGREEN("#00fa9a", 0, 250, 154), //
    MEDIUMTURQUOISE("#48d1cc", 72, 209, 204), //
    MEDIUMVIOLETRED("#c71585", 199, 21, 133), //
    MIDNIGHTBLUE("#191970", 25, 25, 112), //
    MINTCREAM("#f5fffa", 245, 255, 250), //
    MISTYROSE("#ffe4e1", 255, 228, 225), //
    MOCCASIN("#ffe4b5", 255, 228, 181), //
    NAVAJOWHITE("#ffdead", 255, 222, 173), //
    NAVY("#000080", 0, 0, 128), //
    OLDLACE("#fdf5e6", 253, 245, 230), //
    OLIVE("#808000", 128, 128, 0), //
    OLIVEDRAB("#6b8e23", 107, 142, 35), //
    ORANGE("#ffa500", 255, 165, 0), //
    ORANGERED("#ff4500", 255, 69, 0), //
    ORCHID("#da70d6", 218, 112, 214), //
    PALEGOLDENROD("#eee8aa", 238, 232, 170), //
    PALEGREEN("#98fb98", 152, 251, 152), //
    PALETURQUOISE("#afeeee", 175, 238, 238), //
    PALEVIOLETRED("#db7093", 219, 112, 147), //
    PAPAYAWHIP("#ffefd5", 255, 239, 213), //
    PEACHPUFF("#ffdab9", 255, 218, 185), //
    PERU("#cd853f", 205, 133, 63), //
    PINK("#ffc0cb", 255, 192, 203), //
    PLUM("#dda0dd", 221, 160, 221), //
    POWDERBLUE("#b0e0e6", 176, 224, 230), //
    PURPLE(" #800080", 128, 0, 128), //
    RED("#ff0000", 255, 0, 0), //
    ROSYBROWN("#bc8f8f", 188, 143, 143), //
    ROYALBLUE("#4169e1", 65, 105, 225), //
    SADDLEBROWN("#8b4513", 139, 69, 19), //
    SALMON("#fa8072", 250, 128, 114), //
    SANDYBROWN("#f4a460", 244, 164, 96), //
    SEAGREEN("#2e8b57", 46, 139, 87), //
    SEASHELL("#fff5ee", 255, 245, 238), //
    SIENNA("#a0522d", 160, 82, 45), //
    SILVER("#c0c0c0", 192, 192, 192), //
    SKYBLUE(" #87ceeb", 135, 206, 235), //
    SLATEBLUE("#6a5acd", 106, 90, 205), //
    SLATEGRAY("#708090", 112, 128, 144), //
    SLATEGREY("#708090", 112, 128, 144), //
    SNOW("#fffafa", 255, 250, 250), //
    SPRINGGREEN("#00ff7f", 0, 255, 127), //
    STEELBLUE("#4682b4", 70, 130, 180), //
    TAN("#d2b48c", 210, 180, 140), //
    TEAL("#008080", 0, 128, 128), //
    THISTLE("#d8bfd8", 216, 191, 216), //
    TOMATO("#ff6347", 255, 99, 71), //
    TURQUOISE("#40e0d0", 64, 224, 208), //
    VIOLET("#ee82ee", 238, 130, 238), //
    WHEAT("#f5deb3", 245, 222, 179), //
    WHITE("#ffffff", 255, 255, 255), //
    WHITESMOKE("#f5f5f5", 245, 245, 245), //
    YELLOW("#ffff00", 255, 255, 0), //
    YELLOWGREEN("#9acd32", 154, 205, 50); //

    private final String m_value;
    private int m_red, m_green, m_blue;

    private Color(String value, int red, int green, int blue) {
        m_value = value;
        m_red = red;
        m_green = green;
        m_blue = blue;
    }

    public String getValue() {
        return this.m_value;
    }

    public int getRed() {
        return this.m_red;
    }

    public int getGreen() {
        return this.m_green;
    }

    public int getBlue() {
        return this.m_blue;
    }

    public String asRgbString() {
        return "rgb(" + this.getRed() + "," + this.getGreen() + "," + this.getBlue() + ")";
    }

}
