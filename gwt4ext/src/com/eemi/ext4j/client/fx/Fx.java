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
package com.eemi.ext4j.client.fx;


/**
 * Interface that provide basic animation and visual effects support. <br/>
 * <br/>
 * It is important to note that although the Fx methods and many non-Fx Element
 * methods support "method chaining" in that they return the Element object
 * itself as the method return value, it is not always possible to mix the two
 * in a single method chain. The Fx methods use an internal effects queue so
 * that each effect can be properly timed and sequenced. Non-Fx methods, on the
 * other hand, have no such internal queueing and will always execute
 * immediately. For this reason, while it may be possible to mix certain Fx and
 * non-Fx method calls in a single chain, it may not always provide the expected
 * results and should be done with care. <br/>
 * <br/>
 * 
 */
public interface Fx {

    /**
     * Fade an element in (from transparent to opaque).
     * <p/>
     * 
     * <pre>
     * // default: fade in from opacity 0 to 100%
     * el.fadeIn();
     * </pre>
     * 
     * @return this
     */
    Fx fadeIn();

    /**
     * Fade an element in (from transparent to opaque). The ending opacity can
     * be specified using the "endOpacity" config option.
     * <p/>
     * 
     * <pre>
     * // fade in from opacity 0 to 75% over 2 seconds
     * el.fadeIn(new FxConfig() {
     * {
     *    setEndOpacity(0.75);
     *    setDuration(2);
     * });
     * </pre>
     * 
     * @param config
     *            the Fx config
     * @return this
     */
    Fx fadeIn(FxConfig config);

    /**
     * Fade an element out (from opaque to transparent) from the element's
     * current opacity to 0.
     * 
     * @return this
     */
    Fx fadeOut();

    /**
     * Fade an element out (from opaque to transparent). The ending opacity can
     * be specified using the "endOpacity" config option.
     * <p/>
     * <p/>
     * 
     * <pre>
     * // fade out from the element's current opacity to 25% over 2 seconds
     * el.fadeOut(new FxConfig() {
     * {
     *    setEndOpacity(0.25);
     *    setDuration(2);
     * });
     * </pre>
     * 
     * @param config
     *            the Fx config
     * @return this
     */
    Fx fadeOut(FxConfig config);

    /**
     * Shows a ripple of exploding, attenuating borders to draw attention to an
     * Element.
     * 
     * @return this
     */
    Fx frame();

    /**
     * Shows a ripple of exploding, attenuating borders to draw attention to an
     * Element.
     * <p/>
     * <p/>
     * 
     * <pre>
     * // 3 red ripples lasting 3 seconds total
     * el.frame("ff0000", 3, new FxConfig() {
     *                     {
     *                         setDurtion(3);
     *                     }));
     * </pre>
     * 
     * @param color
     *            he color of the border. Should be a 6 char hex color without
     *            the leading # (defaults to light blue: 'C3DAF9').
     * @param count
     *            The number of ripples to display (defaults to 1)
     * @param config
     *            the Fx config
     * @return this
     */
    Fx frame(String color, int count, FxConfig config);

    /**
     * Slides the element while fading it out of view.
     * 
     * @return this
     */
    Fx ghost();

    /**
     * Slides the element while fading it out of view.
     * 
     * @param anchorPosition
     *            the anchor position
     * @param config
     *            the Fx config
     * @return true
     */
    Fx ghost(String anchorPosition, FxConfig config);

    /**
     * Returns true if the element has any effects actively running or queued,
     * else returns false.
     * 
     * @return True if element has active effects, else false
     */
    boolean hasActiveFx();

    /**
     * Returns true if the element is currently blocking so that no other effect
     * can be queued until this effect is finished, else returns false if
     * blocking is not set. This is commonly used to ensure that an effect
     * initiated by a user action runs to completion prior to the same effect
     * being restarted (e.g., firing only one effect even if the user clicks
     * several times).
     * 
     * @return True if blocking, else false
     */
    boolean hasFxBlock();

    /**
     * Highlights the Element by setting a color (applies to the
     * background-color by default, but can be changed using the "attr" config
     * option) and then fading back to the original color.
     * 
     * @return this
     */
    Fx highlight();

    /**
     * Highlights the Element by setting a color (applies to the
     * background-color by default, but can be changed using the "attr" config
     * option) and then fading back to the original color.
     * 
     * @param color
     *            The highlight color. Should be a 6 char hex color without the
     *            leading # (defaults to yellow: 'ffff9c')
     * @param config
     *            the Fx config
     * @return this
     */
    Fx highlight(String color, FxConfig config);

    /**
     * Highlights the Element by setting a color (applies to the
     * background-color by default, but can be changed using the "attr" config
     * option) and then fading back to the original color. If no original color
     * is available, you should provide the "endColor" config option which will
     * be cleared after the animation.
     * <p/>
     * <p/>
     * 
     * <pre>
     * // highlight foreground text to blue for 2 seconds
     * el.highlight("0000ff", "color", "ffffff", new FxConfig() {{
     *                        setDuration(3)
     *                        }});
     * 
     * @param color    The highlight color. Should be a 6 char hex color without the leading # (defaults to yellow: 'ffff9c')
     * @param attr     the attribute. Can be any valid CSS property (attribute) that supports a color value. Default is 'background-color'
     * @param endColor the end color
     * @param config   the Fx config
     * @return this
     */
    Fx highlight(String color, String attr, String endColor, FxConfig config);

    /**
     * Creates a pause before any subsequent queued effects begin. If there are
     * no effects queued after the pause it will have no effect.
     * 
     * @param seconds
     *            The length of time to pause (in seconds)
     * @return this
     */
    Fx pause(int seconds);

    /**
     * Fades the element out while slowly expanding it in all directions. When
     * the effect is completed, the element will be hidden (visibility =
     * 'hidden') but block elements will still take up space in the document.
     * 
     * @return this
     */
    Fx puff();

    /**
     * Fades the element out while slowly expanding it in all directions. When
     * the effect is completed, the element will be hidden (visibility =
     * 'hidden') but block elements will still take up space in the document.
     * The element can be removed from the DOM using the 'remove' config option
     * if desired.
     * 
     * @param remove
     *            true to remove element
     * @param config
     *            the Fx config
     * @return this
     */
    Fx puff(boolean remove, FxConfig config);

    /**
     * Animates the transition of an element's dimensions from a starting
     * height/width to an ending height/width.
     * 
     * @param width
     *            The new width
     * @param height
     *            The new height
     * @return this
     */
    Fx scale(int width, int height);

    /**
     * Animates the transition of an element's dimensions from a starting
     * height/width to an ending height/width.
     * 
     * @param width
     *            The new width
     * @param height
     *            The new height
     * @param config
     *            the Fx config
     * @return this
     */
    Fx scale(int width, int height, FxConfig config);

    /**
     * Ensures that all effects queued after sequenceFx is called on the element
     * are run in sequence. This is the opposite of syncFx.
     * 
     * @return this
     */
    Fx sequenceFx();

    /**
     * Animates the transition of any combination of an element's dimensions, xy
     * position and/or opacity. Any of these properties not specified in the
     * config object will not be changed. This effect requires that at least one
     * new dimension, position or opacity setting must be passed in on the
     * config object in order for the function to have any effect.
     * 
     * @param x
     *            X postionion
     * @param y
     *            Y position
     * @param width
     *            the new width
     * @param height
     *            the new height
     * @param config
     *            the Fx config
     * @return this
     */
    Fx shift(int x, int y, int width, int height, FxConfig config);

    /**
     * Slides the element into view. An anchor point can be optionally passed to
     * set the point of origin for the slide effect. This function automatically
     * handles wrapping the element with a fixed-size container if needed.
     * Slides in from top by default.
     * 
     * @return this
     */
    Fx slideIn();

    /**
     * Slides the element into view. An anchor point can be optionally passed to
     * set the point of origin for the slide effect. This function automatically
     * handles wrapping the element with a fixed-size container if needed.
     * 
     * @param anchorPosition
     *            the anchor position
     * @param config
     *            the Fx config
     * @return this
     */
    Fx slideIn(String anchorPosition, FxConfig config);

    /**
     * Slides the element out of view. An anchor point can be optionally passed
     * to set the end point for the slide effect. When the effect is completed,
     * the element will be hidden (visibility = 'hidden') but block elements
     * will still take up space in the document. This function automatically
     * handles wrapping the element with a fixed-size container if needed.
     * 
     * @return this
     */
    Fx slideOut();

    /**
     * Slides the element out of view. An anchor point can be optionally passed
     * to set the end point for the slide effect. When the effect is completed,
     * the element will be hidden (visibility = 'hidden') but block elements
     * will still take up space in the document. This function automatically
     * handles wrapping the element with a fixed-size container if needed.
     * 
     * @param remove
     *            true to remove element from the DOM
     * @param anchorPosition
     *            the anchor position
     * @param config
     *            the Fx config
     * @return this
     */
    Fx slideOut(boolean remove, String anchorPosition, FxConfig config);

    /**
     * Stops any running effects and clears the element's internal effects queue
     * if it contains any additional effects that haven't started yet.
     * 
     * @return this
     */
    Fx stopFx();

    /**
     * Blinks the element as if it was clicked and then collapses on its center
     * (similar to switching off a television). When the effect is completed,
     * the element will be hidden (visibility = 'hidden') but block elements
     * will still take up space in the document.
     * 
     * @return this
     */
    Fx switchOff();

    /**
     * Blinks the element as if it was clicked and then collapses on its center
     * (similar to switching off a television). When the effect is completed,
     * the element will be hidden (visibility = 'hidden') but block elements
     * will still take up space in the document.
     * 
     * @param remove
     *            true to remove element from the DOM
     * @param config
     *            the Fx config
     * @return this
     */
    Fx switchOff(boolean remove, FxConfig config);

    /**
     * Ensures that all effects queued after syncFx is called on the element are
     * run concurrently. This is the opposite of sequenceFx.
     * 
     * @return this
     */
    Fx syncFx();
}
