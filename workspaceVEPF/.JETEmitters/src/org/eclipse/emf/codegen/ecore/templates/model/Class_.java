package org.eclipse.emf.codegen.ecore.templates.model;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

public class Class_
{
  protected static String nl;
  public static synchronized Class_ create(String lineSeparator)
  {
    nl = lineSeparator;
    Class_ result = new Class_();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "//------------------------------------------------------------------------------" + NL + "// Copyright (c) 2005, 2006 IBM Corporation and others." + NL + "// All rights reserved. This program and the accompanying materials" + NL + "// are made available under the terms of the Eclipse Public License v1.0" + NL + "// which accompanies this distribution, and is available at" + NL + "// http://www.eclipse.org/legal/epl-v10.html" + NL + "//" + NL + "// Contributors:" + NL + "// IBM Corporation - initial implementation" + NL + "//------------------------------------------------------------------------------";
  protected final String TEXT_3 = NL + "package ";
  protected final String TEXT_4 = ";";
  protected final String TEXT_5 = NL + "package ";
  protected final String TEXT_6 = ";";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * A representation of the model object '<em><b>";
  protected final String TEXT_10 = "</b></em>'." + NL + " * <!-- end-user-doc -->";
  protected final String TEXT_11 = NL + " *" + NL + " * <!-- begin-model-doc -->" + NL + " * ";
  protected final String TEXT_12 = NL + " * <!-- end-model-doc -->";
  protected final String TEXT_13 = NL + " *";
  protected final String TEXT_14 = NL + " * <p>" + NL + " * The following features are supported:" + NL + " * <ul>";
  protected final String TEXT_15 = NL + " *   <li>{@link ";
  protected final String TEXT_16 = "#";
  protected final String TEXT_17 = " <em>";
  protected final String TEXT_18 = "</em>}</li>";
  protected final String TEXT_19 = NL + " * </ul>" + NL + " * </p>";
  protected final String TEXT_20 = NL + " *";
  protected final String TEXT_21 = NL + " * @see ";
  protected final String TEXT_22 = "#get";
  protected final String TEXT_23 = "()";
  protected final String TEXT_24 = NL + " * @model ";
  protected final String TEXT_25 = NL + " *        ";
  protected final String TEXT_26 = NL + " * @model";
  protected final String TEXT_27 = NL + " * @extends ";
  protected final String TEXT_28 = NL + " * @generated" + NL + " */";
  protected final String TEXT_29 = NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * An implementation of the model object '<em><b>";
  protected final String TEXT_30 = "</b></em>'." + NL + " * <!-- end-user-doc -->" + NL + " * <p>";
  protected final String TEXT_31 = NL + " * The following features are implemented:" + NL + " * <ul>";
  protected final String TEXT_32 = NL + " *   <li>{@link ";
  protected final String TEXT_33 = "#";
  protected final String TEXT_34 = " <em>";
  protected final String TEXT_35 = "</em>}</li>";
  protected final String TEXT_36 = NL + " * </ul>";
  protected final String TEXT_37 = NL + " * </p>" + NL + " *" + NL + " * @generated" + NL + " */";
  protected final String TEXT_38 = NL + "public";
  protected final String TEXT_39 = " abstract";
  protected final String TEXT_40 = " class ";
  protected final String TEXT_41 = NL + "public interface ";
  protected final String TEXT_42 = NL + "{";
  protected final String TEXT_43 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t";
  protected final String TEXT_44 = " copyright = \"";
  protected final String TEXT_45 = "\";";
  protected final String TEXT_46 = NL;
  protected final String TEXT_47 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
  protected final String TEXT_48 = " mofDriverNumber = \"";
  protected final String TEXT_49 = "\";";
  protected final String TEXT_50 = NL;
  protected final String TEXT_51 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final long serialVersionUID = 1L;" + NL;
  protected final String TEXT_52 = NL + "\t/**" + NL + "\t * An array of objects representing the values of non-primitive features." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Object[] ";
  protected final String TEXT_53 = " = null;" + NL;
  protected final String TEXT_54 = NL + "\t/**" + NL + "\t * A bit field representing the indices of non-primitive feature values." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected int ";
  protected final String TEXT_55 = " = 0;" + NL;
  protected final String TEXT_56 = NL + "\t/**" + NL + "\t * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected int ";
  protected final String TEXT_57 = " = 0;" + NL;
  protected final String TEXT_58 = NL + "\t/**" + NL + "\t * The cached value of the '{@link #";
  protected final String TEXT_59 = "() <em>";
  protected final String TEXT_60 = "</em>}' ";
  protected final String TEXT_61 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_62 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_63 = " ";
  protected final String TEXT_64 = " = null;" + NL;
  protected final String TEXT_65 = NL + "\t/**" + NL + "\t * The empty value for the '{@link #";
  protected final String TEXT_66 = "() <em>";
  protected final String TEXT_67 = "</em>}' array accessor." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_68 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final ";
  protected final String TEXT_69 = "[] ";
  protected final String TEXT_70 = "_EEMPTY_ARRAY = new ";
  protected final String TEXT_71 = " [0];" + NL;
  protected final String TEXT_72 = NL + "\t/**" + NL + "\t * The default value of the '{@link #";
  protected final String TEXT_73 = "() <em>";
  protected final String TEXT_74 = "</em>}' ";
  protected final String TEXT_75 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_76 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final ";
  protected final String TEXT_77 = " ";
  protected final String TEXT_78 = "_EDEFAULT = ";
  protected final String TEXT_79 = ";";
  protected final String TEXT_80 = NL;
  protected final String TEXT_81 = NL + "\t/**" + NL + "\t * An additional set of bit flags representing the values of boolean attributes and whether unsettable features have been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected int ";
  protected final String TEXT_82 = " = 0;" + NL;
  protected final String TEXT_83 = NL + "\t/**" + NL + "\t * The flag representing the value of the '{@link #";
  protected final String TEXT_84 = "() <em>";
  protected final String TEXT_85 = "</em>}' ";
  protected final String TEXT_86 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_87 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final int ";
  protected final String TEXT_88 = "_EFLAG = 1 ";
  protected final String TEXT_89 = ";" + NL;
  protected final String TEXT_90 = NL + "\t/**" + NL + "\t * The cached value of the '{@link #";
  protected final String TEXT_91 = "() <em>";
  protected final String TEXT_92 = "</em>}' ";
  protected final String TEXT_93 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_94 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_95 = " ";
  protected final String TEXT_96 = " = ";
  protected final String TEXT_97 = "_EDEFAULT;" + NL;
  protected final String TEXT_98 = NL + "\t/**" + NL + "\t * An additional set of bit flags representing the values of boolean attributes and whether unsettable features have been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected int ";
  protected final String TEXT_99 = " = 0;" + NL;
  protected final String TEXT_100 = NL + "\t/**" + NL + "\t * The flag representing whether the ";
  protected final String TEXT_101 = " ";
  protected final String TEXT_102 = " has been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final int ";
  protected final String TEXT_103 = "_ESETFLAG = 1 ";
  protected final String TEXT_104 = ";" + NL;
  protected final String TEXT_105 = NL + "\t/**" + NL + "\t * This is true if the ";
  protected final String TEXT_106 = " ";
  protected final String TEXT_107 = " has been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected boolean ";
  protected final String TEXT_108 = "ESet = false;" + NL;
  protected final String TEXT_109 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_110 = "()" + NL + "\t{" + NL + "\t\tsuper();";
  protected final String TEXT_111 = NL + "\t\t";
  protected final String TEXT_112 = " |= ";
  protected final String TEXT_113 = "_EFLAG;";
  protected final String TEXT_114 = NL + "  " + NL + " //UMA-->" + NL + " \t\treassignDefaultValues();" + NL + " //UMA<--" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_115 = " eStaticClass()" + NL + "\t{" + NL + "\t\treturn ";
  protected final String TEXT_116 = ";" + NL + "\t}" + NL;
  protected final String TEXT_117 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_118 = NL + "\t";
  protected final String TEXT_119 = "[] ";
  protected final String TEXT_120 = "();" + NL;
  protected final String TEXT_121 = NL + "\tpublic ";
  protected final String TEXT_122 = "[] ";
  protected final String TEXT_123 = "()" + NL + "\t{";
  protected final String TEXT_124 = NL + "\t\t";
  protected final String TEXT_125 = " list = (";
  protected final String TEXT_126 = ")";
  protected final String TEXT_127 = "();" + NL + "\t\tif (list.isEmpty()) return ";
  protected final String TEXT_128 = "_EEMPTY_ARRAY;";
  protected final String TEXT_129 = NL + "\t\tif (";
  protected final String TEXT_130 = " == null || ";
  protected final String TEXT_131 = ".isEmpty()) return ";
  protected final String TEXT_132 = "_EEMPTY_ARRAY;" + NL + "\t\t";
  protected final String TEXT_133 = " list = (";
  protected final String TEXT_134 = ")";
  protected final String TEXT_135 = ";";
  protected final String TEXT_136 = NL + "\t\tlist.shrink();" + NL + "\t\treturn (";
  protected final String TEXT_137 = "[])list.data();" + NL + "\t}" + NL;
  protected final String TEXT_138 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_139 = NL + "\t";
  protected final String TEXT_140 = " get";
  protected final String TEXT_141 = "(int index);" + NL;
  protected final String TEXT_142 = NL + "\tpublic ";
  protected final String TEXT_143 = " get";
  protected final String TEXT_144 = "(int index)" + NL + "\t{" + NL + "\t\treturn (";
  protected final String TEXT_145 = ")";
  protected final String TEXT_146 = "().get(index);" + NL + "\t}" + NL;
  protected final String TEXT_147 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_148 = NL + "\tint get";
  protected final String TEXT_149 = "Length();" + NL;
  protected final String TEXT_150 = NL + "\tpublic int get";
  protected final String TEXT_151 = "Length()" + NL + "\t{";
  protected final String TEXT_152 = NL + "\t\treturn ";
  protected final String TEXT_153 = "().size();";
  protected final String TEXT_154 = NL + "\t\treturn ";
  protected final String TEXT_155 = " == null ? 0 : ";
  protected final String TEXT_156 = ".size();";
  protected final String TEXT_157 = NL + "\t}" + NL;
  protected final String TEXT_158 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_159 = NL + "\tvoid set";
  protected final String TEXT_160 = "(";
  protected final String TEXT_161 = "[] new";
  protected final String TEXT_162 = ");" + NL;
  protected final String TEXT_163 = NL + "\tpublic void set";
  protected final String TEXT_164 = "(";
  protected final String TEXT_165 = "[] new";
  protected final String TEXT_166 = ")" + NL + "\t{" + NL + "\t\t((";
  protected final String TEXT_167 = ")";
  protected final String TEXT_168 = "()).setData(new";
  protected final String TEXT_169 = ".length, new";
  protected final String TEXT_170 = ");" + NL + "\t}" + NL;
  protected final String TEXT_171 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_172 = NL + "\tvoid set";
  protected final String TEXT_173 = "(int index, ";
  protected final String TEXT_174 = " element);" + NL;
  protected final String TEXT_175 = NL + "\tpublic void set";
  protected final String TEXT_176 = "(int index, ";
  protected final String TEXT_177 = " element)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_178 = "().set(index, element);" + NL + "\t}" + NL;
  protected final String TEXT_179 = NL + "\t/**" + NL + "\t * Returns the value of the '<em><b>";
  protected final String TEXT_180 = "</b></em>' ";
  protected final String TEXT_181 = ".";
  protected final String TEXT_182 = NL + "\t * The key is of type ";
  protected final String TEXT_183 = "list of {@link ";
  protected final String TEXT_184 = "}";
  protected final String TEXT_185 = "{@link ";
  protected final String TEXT_186 = "}";
  protected final String TEXT_187 = "," + NL + "\t * and the value is of type ";
  protected final String TEXT_188 = "list of {@link ";
  protected final String TEXT_189 = "}";
  protected final String TEXT_190 = "{@link ";
  protected final String TEXT_191 = "}";
  protected final String TEXT_192 = ",";
  protected final String TEXT_193 = NL + "\t * The list contents are of type {@link ";
  protected final String TEXT_194 = "}.";
  protected final String TEXT_195 = NL + "\t * The default value is <code>";
  protected final String TEXT_196 = "</code>.";
  protected final String TEXT_197 = NL + "\t * The literals are from the enumeration {@link ";
  protected final String TEXT_198 = "}.";
  protected final String TEXT_199 = NL + "\t * It is bidirectional and its opposite is '{@link ";
  protected final String TEXT_200 = "#";
  protected final String TEXT_201 = " <em>";
  protected final String TEXT_202 = "</em>}'.";
  protected final String TEXT_203 = NL + "\t * <!-- begin-user-doc -->";
  protected final String TEXT_204 = NL + "\t * <p>" + NL + "\t * If the meaning of the '<em>";
  protected final String TEXT_205 = "</em>' ";
  protected final String TEXT_206 = " isn't clear," + NL + "\t * there really should be more of a description here..." + NL + "\t * </p>";
  protected final String TEXT_207 = NL + "\t * <!-- end-user-doc -->";
  protected final String TEXT_208 = NL + "\t * <!-- begin-model-doc -->" + NL + "\t * ";
  protected final String TEXT_209 = NL + "\t * <!-- end-model-doc -->";
  protected final String TEXT_210 = NL + "\t * @return the value of the '<em>";
  protected final String TEXT_211 = "</em>' ";
  protected final String TEXT_212 = ".";
  protected final String TEXT_213 = NL + "\t * @see ";
  protected final String TEXT_214 = NL + "\t * @see #isSet";
  protected final String TEXT_215 = "()";
  protected final String TEXT_216 = NL + "\t * @see #unset";
  protected final String TEXT_217 = "()";
  protected final String TEXT_218 = NL + "\t * @see #set";
  protected final String TEXT_219 = "(";
  protected final String TEXT_220 = ")";
  protected final String TEXT_221 = NL + "\t * @see ";
  protected final String TEXT_222 = "#get";
  protected final String TEXT_223 = "()";
  protected final String TEXT_224 = NL + "\t * @see ";
  protected final String TEXT_225 = "#";
  protected final String TEXT_226 = NL + "\t * @model ";
  protected final String TEXT_227 = NL + "\t *        ";
  protected final String TEXT_228 = NL + "\t * @model";
  protected final String TEXT_229 = NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_230 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_231 = NL + "\t";
  protected final String TEXT_232 = " ";
  protected final String TEXT_233 = "();" + NL;
  protected final String TEXT_234 = NL + "\tpublic ";
  protected final String TEXT_235 = " ";
  protected final String TEXT_236 = "()" + NL + "\t{";
  protected final String TEXT_237 = NL + "\t\treturn ";
  protected final String TEXT_238 = "(";
  protected final String TEXT_239 = "(";
  protected final String TEXT_240 = ")eGet(";
  protected final String TEXT_241 = ", true)";
  protected final String TEXT_242 = ").";
  protected final String TEXT_243 = "()";
  protected final String TEXT_244 = ";";
  protected final String TEXT_245 = NL + "\t\t";
  protected final String TEXT_246 = " ";
  protected final String TEXT_247 = " = (";
  protected final String TEXT_248 = ")eVirtualGet(";
  protected final String TEXT_249 = ");";
  protected final String TEXT_250 = NL + "\t\tif (";
  protected final String TEXT_251 = " == null)" + NL + "\t\t{";
  protected final String TEXT_252 = NL + "\t\t\teVirtualSet(";
  protected final String TEXT_253 = ", ";
  protected final String TEXT_254 = " = new ";
  protected final String TEXT_255 = ");";
  protected final String TEXT_256 = NL + "\t\t\t";
  protected final String TEXT_257 = " = new ";
  protected final String TEXT_258 = ";";
  protected final String TEXT_259 = NL + "\t\t}" + NL + "\t\treturn ";
  protected final String TEXT_260 = ";";
  protected final String TEXT_261 = NL + "\t\tif (eContainerFeatureID != ";
  protected final String TEXT_262 = ") return null;" + NL + "\t\treturn (";
  protected final String TEXT_263 = ")eContainer();";
  protected final String TEXT_264 = NL + "\t\t";
  protected final String TEXT_265 = " ";
  protected final String TEXT_266 = " = (";
  protected final String TEXT_267 = ")eVirtualGet(";
  protected final String TEXT_268 = ", ";
  protected final String TEXT_269 = "_EDEFAULT";
  protected final String TEXT_270 = ");";
  protected final String TEXT_271 = NL + "\t\tif (";
  protected final String TEXT_272 = " != null && ";
  protected final String TEXT_273 = ".eIsProxy())" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_274 = " old";
  protected final String TEXT_275 = " = (";
  protected final String TEXT_276 = ")";
  protected final String TEXT_277 = ";" + NL + "\t\t\t";
  protected final String TEXT_278 = " = ";
  protected final String TEXT_279 = "eResolveProxy(old";
  protected final String TEXT_280 = ");" + NL + "\t\t\tif (";
  protected final String TEXT_281 = " != old";
  protected final String TEXT_282 = ")" + NL + "\t\t\t{";
  protected final String TEXT_283 = NL + "\t\t\t\t";
  protected final String TEXT_284 = " new";
  protected final String TEXT_285 = " = (";
  protected final String TEXT_286 = ")";
  protected final String TEXT_287 = ";";
  protected final String TEXT_288 = NL + "\t\t\t\t";
  protected final String TEXT_289 = " msgs = old";
  protected final String TEXT_290 = ".eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_291 = ", null, null);";
  protected final String TEXT_292 = NL + "\t\t\t\t";
  protected final String TEXT_293 = " msgs =  old";
  protected final String TEXT_294 = ".eInverseRemove(this, ";
  protected final String TEXT_295 = ", ";
  protected final String TEXT_296 = ".class, null);";
  protected final String TEXT_297 = NL + "\t\t\t\tif (new";
  protected final String TEXT_298 = ".eInternalContainer() == null)" + NL + "\t\t\t\t{";
  protected final String TEXT_299 = NL + "\t\t\t\t\tmsgs = new";
  protected final String TEXT_300 = ".eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_301 = ", null, msgs);";
  protected final String TEXT_302 = NL + "\t\t\t\t\tmsgs =  new";
  protected final String TEXT_303 = ".eInverseAdd(this, ";
  protected final String TEXT_304 = ", ";
  protected final String TEXT_305 = ".class, msgs);";
  protected final String TEXT_306 = NL + "\t\t\t\t}" + NL + "\t\t\t\tif (msgs != null) msgs.dispatch();";
  protected final String TEXT_307 = NL + "\t\t\t\teVirtualSet(";
  protected final String TEXT_308 = ", ";
  protected final String TEXT_309 = ");";
  protected final String TEXT_310 = NL + "\t\t\t\tif (eNotificationRequired())" + NL + "\t\t\t\t\teNotify(new ";
  protected final String TEXT_311 = "(this, ";
  protected final String TEXT_312 = ".RESOLVE, ";
  protected final String TEXT_313 = ", old";
  protected final String TEXT_314 = ", ";
  protected final String TEXT_315 = "));";
  protected final String TEXT_316 = NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_317 = NL + "\t\treturn (";
  protected final String TEXT_318 = ")eVirtualGet(";
  protected final String TEXT_319 = ", ";
  protected final String TEXT_320 = "_EDEFAULT";
  protected final String TEXT_321 = ");";
  protected final String TEXT_322 = NL + "\t\treturn (";
  protected final String TEXT_323 = " & ";
  protected final String TEXT_324 = "_EFLAG) != 0;";
  protected final String TEXT_325 = NL + "\t\treturn ";
  protected final String TEXT_326 = ";";
  protected final String TEXT_327 = NL + "\t\t";
  protected final String TEXT_328 = " ";
  protected final String TEXT_329 = " = basicGet";
  protected final String TEXT_330 = "();" + NL + "\t\treturn ";
  protected final String TEXT_331 = " != null && ";
  protected final String TEXT_332 = ".eIsProxy() ? ";
  protected final String TEXT_333 = "eResolveProxy((";
  protected final String TEXT_334 = ")";
  protected final String TEXT_335 = ") : ";
  protected final String TEXT_336 = ";";
  protected final String TEXT_337 = NL + "\t\treturn new ";
  protected final String TEXT_338 = "((";
  protected final String TEXT_339 = ".Internal)((";
  protected final String TEXT_340 = ".Internal.Wrapper)get";
  protected final String TEXT_341 = "()).featureMap().list(";
  protected final String TEXT_342 = "));";
  protected final String TEXT_343 = NL + "\t\treturn (";
  protected final String TEXT_344 = ")((";
  protected final String TEXT_345 = ")get";
  protected final String TEXT_346 = "()).list(";
  protected final String TEXT_347 = ");";
  protected final String TEXT_348 = NL + "\t\treturn ((";
  protected final String TEXT_349 = ".Internal.Wrapper)get";
  protected final String TEXT_350 = "()).featureMap().list(";
  protected final String TEXT_351 = ");";
  protected final String TEXT_352 = NL + "\t\treturn ((";
  protected final String TEXT_353 = ")get";
  protected final String TEXT_354 = "()).list(";
  protected final String TEXT_355 = ");";
  protected final String TEXT_356 = NL + "\t\treturn ";
  protected final String TEXT_357 = "(";
  protected final String TEXT_358 = "(";
  protected final String TEXT_359 = ")((";
  protected final String TEXT_360 = ".Internal.Wrapper)get";
  protected final String TEXT_361 = "()).featureMap().get(";
  protected final String TEXT_362 = ", true)";
  protected final String TEXT_363 = ").";
  protected final String TEXT_364 = "()";
  protected final String TEXT_365 = ";";
  protected final String TEXT_366 = NL + "\t\treturn ";
  protected final String TEXT_367 = "(";
  protected final String TEXT_368 = "(";
  protected final String TEXT_369 = ")get";
  protected final String TEXT_370 = "().get(";
  protected final String TEXT_371 = ", true)";
  protected final String TEXT_372 = ").";
  protected final String TEXT_373 = "()";
  protected final String TEXT_374 = ";";
  protected final String TEXT_375 = NL + "\t\t// TODO: implement this method to return the '";
  protected final String TEXT_376 = "' ";
  protected final String TEXT_377 = NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT";
  protected final String TEXT_378 = NL + "\t\t// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting" + NL + "\t\t// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.";
  protected final String TEXT_379 = "EcoreEMap";
  protected final String TEXT_380 = "BasicFeatureMap";
  protected final String TEXT_381 = "EcoreEList";
  protected final String TEXT_382 = " should be used.";
  protected final String TEXT_383 = NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_384 = NL + "\t}" + NL;
  protected final String TEXT_385 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_386 = " basicGet";
  protected final String TEXT_387 = "()" + NL + "\t{";
  protected final String TEXT_388 = NL + "\t\tif (eContainerFeatureID != ";
  protected final String TEXT_389 = ") return null;" + NL + "\t\treturn (";
  protected final String TEXT_390 = ")eInternalContainer();";
  protected final String TEXT_391 = NL + "\t\treturn (";
  protected final String TEXT_392 = ")eVirtualGet(";
  protected final String TEXT_393 = ");";
  protected final String TEXT_394 = NL + "\t\treturn ";
  protected final String TEXT_395 = ";";
  protected final String TEXT_396 = NL + "\t\treturn (";
  protected final String TEXT_397 = ")((";
  protected final String TEXT_398 = ".Internal.Wrapper)get";
  protected final String TEXT_399 = "()).featureMap().get(";
  protected final String TEXT_400 = ", false);";
  protected final String TEXT_401 = NL + "\t\treturn (";
  protected final String TEXT_402 = ")get";
  protected final String TEXT_403 = "().get(";
  protected final String TEXT_404 = ", false);";
  protected final String TEXT_405 = NL + "\t\t// TODO: implement this method to return the '";
  protected final String TEXT_406 = "' ";
  protected final String TEXT_407 = NL + "\t\t// -> do not perform proxy resolution" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_408 = NL + "\t}" + NL;
  protected final String TEXT_409 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_410 = " basicSet";
  protected final String TEXT_411 = "(";
  protected final String TEXT_412 = " new";
  protected final String TEXT_413 = ", ";
  protected final String TEXT_414 = " msgs)" + NL + "\t{";
  protected final String TEXT_415 = NL + "\t\tmsgs = eBasicSetContainer((";
  protected final String TEXT_416 = ")new";
  protected final String TEXT_417 = ", ";
  protected final String TEXT_418 = ", msgs);";
  protected final String TEXT_419 = NL + "\t\treturn msgs;";
  protected final String TEXT_420 = NL + "\t\tObject old";
  protected final String TEXT_421 = " = eVirtualSet(";
  protected final String TEXT_422 = ", new";
  protected final String TEXT_423 = ");";
  protected final String TEXT_424 = NL + "\t\t";
  protected final String TEXT_425 = " old";
  protected final String TEXT_426 = " = ";
  protected final String TEXT_427 = ";" + NL + "\t\t";
  protected final String TEXT_428 = " = new";
  protected final String TEXT_429 = ";";
  protected final String TEXT_430 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_431 = " == EVIRTUAL_NO_VALUE;";
  protected final String TEXT_432 = NL + "\t\tboolean old";
  protected final String TEXT_433 = "ESet = (";
  protected final String TEXT_434 = " & ";
  protected final String TEXT_435 = "_ESETFLAG) != 0;" + NL + "\t\t";
  protected final String TEXT_436 = " |= ";
  protected final String TEXT_437 = "_ESETFLAG;";
  protected final String TEXT_438 = NL + "\t\tboolean old";
  protected final String TEXT_439 = "ESet = ";
  protected final String TEXT_440 = "ESet;" + NL + "\t\t";
  protected final String TEXT_441 = "ESet = true;";
  protected final String TEXT_442 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t{";
  protected final String TEXT_443 = NL + "\t\t\t";
  protected final String TEXT_444 = " notification = new ";
  protected final String TEXT_445 = "(this, ";
  protected final String TEXT_446 = ".SET, ";
  protected final String TEXT_447 = ", ";
  protected final String TEXT_448 = "isSetChange ? null : old";
  protected final String TEXT_449 = "old";
  protected final String TEXT_450 = ", new";
  protected final String TEXT_451 = ", ";
  protected final String TEXT_452 = "isSetChange";
  protected final String TEXT_453 = "!old";
  protected final String TEXT_454 = "ESet";
  protected final String TEXT_455 = ");";
  protected final String TEXT_456 = NL + "\t\t\t";
  protected final String TEXT_457 = " notification = new ";
  protected final String TEXT_458 = "(this, ";
  protected final String TEXT_459 = ".SET, ";
  protected final String TEXT_460 = ", ";
  protected final String TEXT_461 = "old";
  protected final String TEXT_462 = " == EVIRTUAL_NO_VALUE ? null : old";
  protected final String TEXT_463 = "old";
  protected final String TEXT_464 = ", new";
  protected final String TEXT_465 = ");";
  protected final String TEXT_466 = NL + "\t\t\tif (msgs == null) msgs = notification; else msgs.add(notification);" + NL + "\t\t}";
  protected final String TEXT_467 = NL + "\t\treturn msgs;";
  protected final String TEXT_468 = NL + "\t\treturn ((";
  protected final String TEXT_469 = ".Internal)((";
  protected final String TEXT_470 = ".Internal.Wrapper)get";
  protected final String TEXT_471 = "()).featureMap()).basicAdd(";
  protected final String TEXT_472 = ", new";
  protected final String TEXT_473 = ", msgs);";
  protected final String TEXT_474 = NL + "\t\treturn ((";
  protected final String TEXT_475 = ".Internal)get";
  protected final String TEXT_476 = "()).basicAdd(";
  protected final String TEXT_477 = ", new";
  protected final String TEXT_478 = ", msgs);";
  protected final String TEXT_479 = NL + "\t\t// TODO: implement this method to set the contained '";
  protected final String TEXT_480 = "' ";
  protected final String TEXT_481 = NL + "\t\t// -> this method is automatically invoked to keep the containment relationship in synch" + NL + "\t\t// -> do not modify other features" + NL + "\t\t// -> return msgs, after adding any generated Notification to it (if it is null, a NotificationChain object must be created first)" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_482 = NL + "\t}" + NL;
  protected final String TEXT_483 = NL + "\t/**" + NL + "\t * Sets the value of the '{@link ";
  protected final String TEXT_484 = "#";
  protected final String TEXT_485 = " <em>";
  protected final String TEXT_486 = "</em>}' ";
  protected final String TEXT_487 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @param value the new value of the '<em>";
  protected final String TEXT_488 = "</em>' ";
  protected final String TEXT_489 = ".";
  protected final String TEXT_490 = NL + "\t * @see ";
  protected final String TEXT_491 = NL + "\t * @see #isSet";
  protected final String TEXT_492 = "()";
  protected final String TEXT_493 = NL + "\t * @see #unset";
  protected final String TEXT_494 = "()";
  protected final String TEXT_495 = NL + "\t * @see #";
  protected final String TEXT_496 = "()" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_497 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_498 = NL + "\tvoid set";
  protected final String TEXT_499 = "(";
  protected final String TEXT_500 = " value);" + NL;
  protected final String TEXT_501 = NL + "\tpublic void set";
  protected final String TEXT_502 = "(";
  protected final String TEXT_503 = " new";
  protected final String TEXT_504 = ")" + NL + "\t{";
  protected final String TEXT_505 = NL + "\t\teSet(";
  protected final String TEXT_506 = ", ";
  protected final String TEXT_507 = "new ";
  protected final String TEXT_508 = "(";
  protected final String TEXT_509 = "new";
  protected final String TEXT_510 = ")";
  protected final String TEXT_511 = ");";
  protected final String TEXT_512 = NL + "\t\tif (new";
  protected final String TEXT_513 = " != eInternalContainer() || (eContainerFeatureID != ";
  protected final String TEXT_514 = " && new";
  protected final String TEXT_515 = " != null))" + NL + "\t\t{" + NL + "\t\t\tif (";
  protected final String TEXT_516 = ".isAncestor(this, ";
  protected final String TEXT_517 = "new";
  protected final String TEXT_518 = "))" + NL + "\t\t\t\tthrow new ";
  protected final String TEXT_519 = "(\"Recursive containment not allowed for \" + toString());";
  protected final String TEXT_520 = NL + "\t\t\t";
  protected final String TEXT_521 = " msgs = null;" + NL + "\t\t\tif (eInternalContainer() != null)" + NL + "\t\t\t\tmsgs = eBasicRemoveFromContainer(msgs);" + NL + "\t\t\tif (new";
  protected final String TEXT_522 = " != null)" + NL + "\t\t\t\tmsgs = ((";
  protected final String TEXT_523 = ")new";
  protected final String TEXT_524 = ").eInverseAdd(this, ";
  protected final String TEXT_525 = ", ";
  protected final String TEXT_526 = ".class, msgs);" + NL + "\t\t\tmsgs = basicSet";
  protected final String TEXT_527 = "(";
  protected final String TEXT_528 = "new";
  protected final String TEXT_529 = ", msgs);" + NL + "\t\t\tif (msgs != null) msgs.dispatch();" + NL + "\t\t}";
  protected final String TEXT_530 = NL + "\t\telse if (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
  protected final String TEXT_531 = "(this, ";
  protected final String TEXT_532 = ".SET, ";
  protected final String TEXT_533 = ", new";
  protected final String TEXT_534 = ", new";
  protected final String TEXT_535 = "));";
  protected final String TEXT_536 = NL + "\t\t";
  protected final String TEXT_537 = " ";
  protected final String TEXT_538 = " = (";
  protected final String TEXT_539 = ")eVirtualGet(";
  protected final String TEXT_540 = ");";
  protected final String TEXT_541 = NL + "\t\tif (new";
  protected final String TEXT_542 = " != ";
  protected final String TEXT_543 = ")" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_544 = " msgs = null;" + NL + "\t\t\tif (";
  protected final String TEXT_545 = " != null)";
  protected final String TEXT_546 = NL + "\t\t\t\tmsgs = ((";
  protected final String TEXT_547 = ")";
  protected final String TEXT_548 = ").eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_549 = ", null, msgs);" + NL + "\t\t\tif (new";
  protected final String TEXT_550 = " != null)" + NL + "\t\t\t\tmsgs = ((";
  protected final String TEXT_551 = ")new";
  protected final String TEXT_552 = ").eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_553 = ", null, msgs);";
  protected final String TEXT_554 = NL + "\t\t\t\tmsgs = ((";
  protected final String TEXT_555 = ")";
  protected final String TEXT_556 = ").eInverseRemove(this, ";
  protected final String TEXT_557 = ", ";
  protected final String TEXT_558 = ".class, msgs);" + NL + "\t\t\tif (new";
  protected final String TEXT_559 = " != null)" + NL + "\t\t\t\tmsgs = ((";
  protected final String TEXT_560 = ")new";
  protected final String TEXT_561 = ").eInverseAdd(this, ";
  protected final String TEXT_562 = ", ";
  protected final String TEXT_563 = ".class, msgs);";
  protected final String TEXT_564 = NL + "\t\t\tmsgs = basicSet";
  protected final String TEXT_565 = "(";
  protected final String TEXT_566 = "new";
  protected final String TEXT_567 = ", msgs);" + NL + "\t\t\tif (msgs != null) msgs.dispatch();" + NL + "\t\t}";
  protected final String TEXT_568 = NL + "\t\telse" + NL + "    \t{";
  protected final String TEXT_569 = NL + "\t\t\tboolean old";
  protected final String TEXT_570 = "ESet = eVirtualIsSet(";
  protected final String TEXT_571 = ");";
  protected final String TEXT_572 = NL + "\t\t\tboolean old";
  protected final String TEXT_573 = "ESet = (";
  protected final String TEXT_574 = " & ";
  protected final String TEXT_575 = "_ESETFLAG) != 0;";
  protected final String TEXT_576 = NL + "\t\t\t";
  protected final String TEXT_577 = " |= ";
  protected final String TEXT_578 = "_ESETFLAG;";
  protected final String TEXT_579 = NL + "\t\t\tboolean old";
  protected final String TEXT_580 = "ESet = ";
  protected final String TEXT_581 = "ESet;";
  protected final String TEXT_582 = NL + "\t\t\t";
  protected final String TEXT_583 = "ESet = true;";
  protected final String TEXT_584 = NL + "\t\t\tif (eNotificationRequired())" + NL + "\t\t\t\teNotify(new ";
  protected final String TEXT_585 = "(this, ";
  protected final String TEXT_586 = ".SET, ";
  protected final String TEXT_587 = ", new";
  protected final String TEXT_588 = ", new";
  protected final String TEXT_589 = ", !old";
  protected final String TEXT_590 = "ESet));";
  protected final String TEXT_591 = NL + "    \t}";
  protected final String TEXT_592 = NL + "\t\telse if (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
  protected final String TEXT_593 = "(this, ";
  protected final String TEXT_594 = ".SET, ";
  protected final String TEXT_595 = ", new";
  protected final String TEXT_596 = ", new";
  protected final String TEXT_597 = "));";
  protected final String TEXT_598 = NL + "\t\t";
  protected final String TEXT_599 = " old";
  protected final String TEXT_600 = " = (";
  protected final String TEXT_601 = " & ";
  protected final String TEXT_602 = "_EFLAG) != 0;";
  protected final String TEXT_603 = NL + "\t\tif (new";
  protected final String TEXT_604 = ") ";
  protected final String TEXT_605 = " |= ";
  protected final String TEXT_606 = "_EFLAG; else ";
  protected final String TEXT_607 = " &= ~";
  protected final String TEXT_608 = "_EFLAG;";
  protected final String TEXT_609 = NL + "\t\t";
  protected final String TEXT_610 = " old";
  protected final String TEXT_611 = " = ";
  protected final String TEXT_612 = ";";
  protected final String TEXT_613 = NL + "\t\t";
  protected final String TEXT_614 = " ";
  protected final String TEXT_615 = " = new";
  protected final String TEXT_616 = " == null ? ";
  protected final String TEXT_617 = "_EDEFAULT : new";
  protected final String TEXT_618 = ";";
  protected final String TEXT_619 = NL + "\t\t";
  protected final String TEXT_620 = " = new";
  protected final String TEXT_621 = " == null ? ";
  protected final String TEXT_622 = "_EDEFAULT : new";
  protected final String TEXT_623 = ";";
  protected final String TEXT_624 = NL + "\t\t";
  protected final String TEXT_625 = " ";
  protected final String TEXT_626 = " = ";
  protected final String TEXT_627 = "new";
  protected final String TEXT_628 = ";";
  protected final String TEXT_629 = NL + "\t\t";
  protected final String TEXT_630 = " = ";
  protected final String TEXT_631 = "new";
  protected final String TEXT_632 = ";";
  protected final String TEXT_633 = NL + "\t\tObject old";
  protected final String TEXT_634 = " = eVirtualSet(";
  protected final String TEXT_635 = ", ";
  protected final String TEXT_636 = ");";
  protected final String TEXT_637 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_638 = " == EVIRTUAL_NO_VALUE;";
  protected final String TEXT_639 = NL + "\t\tboolean old";
  protected final String TEXT_640 = "ESet = (";
  protected final String TEXT_641 = " & ";
  protected final String TEXT_642 = "_ESETFLAG) != 0;";
  protected final String TEXT_643 = NL + "\t\t";
  protected final String TEXT_644 = " |= ";
  protected final String TEXT_645 = "_ESETFLAG;";
  protected final String TEXT_646 = NL + "\t\tboolean old";
  protected final String TEXT_647 = "ESet = ";
  protected final String TEXT_648 = "ESet;";
  protected final String TEXT_649 = NL + "\t\t";
  protected final String TEXT_650 = "ESet = true;";
  protected final String TEXT_651 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
  protected final String TEXT_652 = "(this, ";
  protected final String TEXT_653 = ".SET, ";
  protected final String TEXT_654 = ", ";
  protected final String TEXT_655 = "isSetChange ? ";
  protected final String TEXT_656 = "null";
  protected final String TEXT_657 = "_EDEFAULT";
  protected final String TEXT_658 = " : old";
  protected final String TEXT_659 = "old";
  protected final String TEXT_660 = ", ";
  protected final String TEXT_661 = "new";
  protected final String TEXT_662 = ", ";
  protected final String TEXT_663 = "isSetChange";
  protected final String TEXT_664 = "!old";
  protected final String TEXT_665 = "ESet";
  protected final String TEXT_666 = "));";
  protected final String TEXT_667 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
  protected final String TEXT_668 = "(this, ";
  protected final String TEXT_669 = ".SET, ";
  protected final String TEXT_670 = ", ";
  protected final String TEXT_671 = "old";
  protected final String TEXT_672 = " == EVIRTUAL_NO_VALUE ? ";
  protected final String TEXT_673 = "null";
  protected final String TEXT_674 = "_EDEFAULT";
  protected final String TEXT_675 = " : old";
  protected final String TEXT_676 = "old";
  protected final String TEXT_677 = ", ";
  protected final String TEXT_678 = "new";
  protected final String TEXT_679 = "));";
  protected final String TEXT_680 = NL + "\t\t((";
  protected final String TEXT_681 = ".Internal)((";
  protected final String TEXT_682 = ".Internal.Wrapper)get";
  protected final String TEXT_683 = "()).featureMap()).set(";
  protected final String TEXT_684 = ", ";
  protected final String TEXT_685 = "new ";
  protected final String TEXT_686 = "(";
  protected final String TEXT_687 = "new";
  protected final String TEXT_688 = ")";
  protected final String TEXT_689 = ");";
  protected final String TEXT_690 = NL + "\t\t((";
  protected final String TEXT_691 = ".Internal)get";
  protected final String TEXT_692 = "()).set(";
  protected final String TEXT_693 = ", ";
  protected final String TEXT_694 = "new ";
  protected final String TEXT_695 = "(";
  protected final String TEXT_696 = "new";
  protected final String TEXT_697 = ")";
  protected final String TEXT_698 = ");";
  protected final String TEXT_699 = NL + "\t\t// TODO: implement this method to set the '";
  protected final String TEXT_700 = "' ";
  protected final String TEXT_701 = NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_702 = NL + "\t}" + NL;
  protected final String TEXT_703 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_704 = " basicUnset";
  protected final String TEXT_705 = "(";
  protected final String TEXT_706 = " msgs)" + NL + "\t{";
  protected final String TEXT_707 = NL + "\t\tObject old";
  protected final String TEXT_708 = " = eVirtualUnset(";
  protected final String TEXT_709 = ");";
  protected final String TEXT_710 = NL + "\t\t";
  protected final String TEXT_711 = " old";
  protected final String TEXT_712 = " = ";
  protected final String TEXT_713 = ";" + NL + "\t\t";
  protected final String TEXT_714 = " = null;";
  protected final String TEXT_715 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_716 = " != EVIRTUAL_NO_VALUE;";
  protected final String TEXT_717 = NL + "\t\tboolean old";
  protected final String TEXT_718 = "ESet = (";
  protected final String TEXT_719 = " & ";
  protected final String TEXT_720 = "_ESETFLAG) != 0;" + NL + "\t\t";
  protected final String TEXT_721 = " &= ~";
  protected final String TEXT_722 = "_ESETFLAG;";
  protected final String TEXT_723 = NL + "\t\tboolean old";
  protected final String TEXT_724 = "ESet = ";
  protected final String TEXT_725 = "ESet;" + NL + "\t\t";
  protected final String TEXT_726 = "ESet = false;";
  protected final String TEXT_727 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_728 = " notification = new ";
  protected final String TEXT_729 = "(this, ";
  protected final String TEXT_730 = ".UNSET, ";
  protected final String TEXT_731 = ", ";
  protected final String TEXT_732 = "isSetChange ? old";
  protected final String TEXT_733 = " : null";
  protected final String TEXT_734 = "old";
  protected final String TEXT_735 = ", null, ";
  protected final String TEXT_736 = "isSetChange";
  protected final String TEXT_737 = "old";
  protected final String TEXT_738 = "ESet";
  protected final String TEXT_739 = ");" + NL + "\t\t\tif (msgs == null) msgs = notification; else msgs.add(notification);" + NL + "\t\t}" + NL + "\t\treturn msgs;";
  protected final String TEXT_740 = NL + "\t\t// TODO: implement this method to unset the contained '";
  protected final String TEXT_741 = "' ";
  protected final String TEXT_742 = NL + "\t\t// -> this method is automatically invoked to keep the containment relationship in synch" + NL + "\t\t// -> do not modify other features" + NL + "\t\t// -> return msgs, after adding any generated Notification to it (if it is null, a NotificationChain object must be created first)" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_743 = NL + "\t}" + NL;
  protected final String TEXT_744 = NL + "\t/**" + NL + "\t * Unsets the value of the '{@link ";
  protected final String TEXT_745 = "#";
  protected final String TEXT_746 = " <em>";
  protected final String TEXT_747 = "</em>}' ";
  protected final String TEXT_748 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->";
  protected final String TEXT_749 = NL + "\t * @see #isSet";
  protected final String TEXT_750 = "()";
  protected final String TEXT_751 = NL + "\t * @see #";
  protected final String TEXT_752 = "()";
  protected final String TEXT_753 = NL + "\t * @see #set";
  protected final String TEXT_754 = "(";
  protected final String TEXT_755 = ")";
  protected final String TEXT_756 = NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_757 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_758 = NL + "\tvoid unset";
  protected final String TEXT_759 = "();" + NL;
  protected final String TEXT_760 = NL + "\tpublic void unset";
  protected final String TEXT_761 = "()" + NL + "\t{";
  protected final String TEXT_762 = NL + "\t\teUnset(";
  protected final String TEXT_763 = ");";
  protected final String TEXT_764 = NL + "\t\t";
  protected final String TEXT_765 = " ";
  protected final String TEXT_766 = " = (";
  protected final String TEXT_767 = ")eVirtualGet(";
  protected final String TEXT_768 = ");";
  protected final String TEXT_769 = NL + "\t\tif (";
  protected final String TEXT_770 = " != null) ((";
  protected final String TEXT_771 = ".Unsettable)";
  protected final String TEXT_772 = ").unset();";
  protected final String TEXT_773 = NL + "\t\t";
  protected final String TEXT_774 = " ";
  protected final String TEXT_775 = " = (";
  protected final String TEXT_776 = ")eVirtualGet(";
  protected final String TEXT_777 = ");";
  protected final String TEXT_778 = NL + "\t\tif (";
  protected final String TEXT_779 = " != null)" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_780 = " msgs = null;";
  protected final String TEXT_781 = NL + "\t\t\tmsgs = ((";
  protected final String TEXT_782 = ")";
  protected final String TEXT_783 = ").eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_784 = ", null, msgs);";
  protected final String TEXT_785 = NL + "\t\t\tmsgs = ((";
  protected final String TEXT_786 = ")";
  protected final String TEXT_787 = ").eInverseRemove(this, ";
  protected final String TEXT_788 = ", ";
  protected final String TEXT_789 = ".class, msgs);";
  protected final String TEXT_790 = NL + "\t\t\tmsgs = basicUnset";
  protected final String TEXT_791 = "(msgs);" + NL + "\t\t\tif (msgs != null) msgs.dispatch();" + NL + "\t\t}" + NL + "\t\telse" + NL + "    \t{";
  protected final String TEXT_792 = NL + "\t\t\tboolean old";
  protected final String TEXT_793 = "ESet = eVirtualIsSet(";
  protected final String TEXT_794 = ");";
  protected final String TEXT_795 = NL + "\t\t\tboolean old";
  protected final String TEXT_796 = "ESet = (";
  protected final String TEXT_797 = " & ";
  protected final String TEXT_798 = "_ESETFLAG) != 0;";
  protected final String TEXT_799 = NL + "\t\t\t";
  protected final String TEXT_800 = " &= ~";
  protected final String TEXT_801 = "_ESETFLAG;";
  protected final String TEXT_802 = NL + "\t\t\tboolean old";
  protected final String TEXT_803 = "ESet = ";
  protected final String TEXT_804 = "ESet;";
  protected final String TEXT_805 = NL + "\t\t\t";
  protected final String TEXT_806 = "ESet = false;";
  protected final String TEXT_807 = NL + "\t\t\tif (eNotificationRequired())" + NL + "\t\t\t\teNotify(new ";
  protected final String TEXT_808 = "(this, ";
  protected final String TEXT_809 = ".UNSET, ";
  protected final String TEXT_810 = ", null, null, old";
  protected final String TEXT_811 = "ESet));";
  protected final String TEXT_812 = NL + "    \t}";
  protected final String TEXT_813 = NL + "\t\t";
  protected final String TEXT_814 = " old";
  protected final String TEXT_815 = " = (";
  protected final String TEXT_816 = " & ";
  protected final String TEXT_817 = "_EFLAG) != 0;";
  protected final String TEXT_818 = NL + "\t\tObject old";
  protected final String TEXT_819 = " = eVirtualUnset(";
  protected final String TEXT_820 = ");";
  protected final String TEXT_821 = NL + "\t\t";
  protected final String TEXT_822 = " old";
  protected final String TEXT_823 = " = ";
  protected final String TEXT_824 = ";";
  protected final String TEXT_825 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_826 = " != EVIRTUAL_NO_VALUE;";
  protected final String TEXT_827 = NL + "\t\tboolean old";
  protected final String TEXT_828 = "ESet = (";
  protected final String TEXT_829 = " & ";
  protected final String TEXT_830 = "_ESETFLAG) != 0;";
  protected final String TEXT_831 = NL + "\t\tboolean old";
  protected final String TEXT_832 = "ESet = ";
  protected final String TEXT_833 = "ESet;";
  protected final String TEXT_834 = NL + "\t\t";
  protected final String TEXT_835 = " = null;";
  protected final String TEXT_836 = NL + "\t\t";
  protected final String TEXT_837 = " &= ~";
  protected final String TEXT_838 = "_ESETFLAG;";
  protected final String TEXT_839 = NL + "\t\t";
  protected final String TEXT_840 = "ESet = false;";
  protected final String TEXT_841 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
  protected final String TEXT_842 = "(this, ";
  protected final String TEXT_843 = ".UNSET, ";
  protected final String TEXT_844 = ", ";
  protected final String TEXT_845 = "isSetChange ? old";
  protected final String TEXT_846 = " : null";
  protected final String TEXT_847 = "old";
  protected final String TEXT_848 = ", null, ";
  protected final String TEXT_849 = "isSetChange";
  protected final String TEXT_850 = "old";
  protected final String TEXT_851 = "ESet";
  protected final String TEXT_852 = "));";
  protected final String TEXT_853 = NL + "\t\tif (";
  protected final String TEXT_854 = "_EDEFAULT) ";
  protected final String TEXT_855 = " |= ";
  protected final String TEXT_856 = "_EFLAG; else ";
  protected final String TEXT_857 = " &= ~";
  protected final String TEXT_858 = "_EFLAG;";
  protected final String TEXT_859 = NL + "\t\t";
  protected final String TEXT_860 = " = ";
  protected final String TEXT_861 = "_EDEFAULT;";
  protected final String TEXT_862 = NL + "\t\t";
  protected final String TEXT_863 = " &= ~";
  protected final String TEXT_864 = "_ESETFLAG;";
  protected final String TEXT_865 = NL + "\t\t";
  protected final String TEXT_866 = "ESet = false;";
  protected final String TEXT_867 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
  protected final String TEXT_868 = "(this, ";
  protected final String TEXT_869 = ".UNSET, ";
  protected final String TEXT_870 = ", ";
  protected final String TEXT_871 = "isSetChange ? old";
  protected final String TEXT_872 = " : ";
  protected final String TEXT_873 = "_EDEFAULT";
  protected final String TEXT_874 = "old";
  protected final String TEXT_875 = ", ";
  protected final String TEXT_876 = "_EDEFAULT, ";
  protected final String TEXT_877 = "isSetChange";
  protected final String TEXT_878 = "old";
  protected final String TEXT_879 = "ESet";
  protected final String TEXT_880 = "));";
  protected final String TEXT_881 = NL + "\t\t((";
  protected final String TEXT_882 = ".Internal)((";
  protected final String TEXT_883 = ".Internal.Wrapper)get";
  protected final String TEXT_884 = "()).featureMap()).clear(";
  protected final String TEXT_885 = ");";
  protected final String TEXT_886 = NL + "\t\t((";
  protected final String TEXT_887 = ".Internal)get";
  protected final String TEXT_888 = "()).clear(";
  protected final String TEXT_889 = ");";
  protected final String TEXT_890 = NL + "\t\t// TODO: implement this method to unset the '";
  protected final String TEXT_891 = "' ";
  protected final String TEXT_892 = NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_893 = NL + "\t}" + NL;
  protected final String TEXT_894 = NL + "\t/**" + NL + "\t * Returns whether the value of the '{@link ";
  protected final String TEXT_895 = "#";
  protected final String TEXT_896 = " <em>";
  protected final String TEXT_897 = "</em>}' ";
  protected final String TEXT_898 = " is set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @return whether the value of the '<em>";
  protected final String TEXT_899 = "</em>' ";
  protected final String TEXT_900 = " is set.";
  protected final String TEXT_901 = NL + "\t * @see #unset";
  protected final String TEXT_902 = "()";
  protected final String TEXT_903 = NL + "\t * @see #";
  protected final String TEXT_904 = "()";
  protected final String TEXT_905 = NL + "\t * @see #set";
  protected final String TEXT_906 = "(";
  protected final String TEXT_907 = ")";
  protected final String TEXT_908 = NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_909 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_910 = NL + "\tboolean isSet";
  protected final String TEXT_911 = "();" + NL;
  protected final String TEXT_912 = NL + "\tpublic boolean isSet";
  protected final String TEXT_913 = "()" + NL + "\t{";
  protected final String TEXT_914 = NL + "\t\treturn eIsSet(";
  protected final String TEXT_915 = ");";
  protected final String TEXT_916 = NL + "\t\t";
  protected final String TEXT_917 = " ";
  protected final String TEXT_918 = " = (";
  protected final String TEXT_919 = ")eVirtualGet(";
  protected final String TEXT_920 = ");";
  protected final String TEXT_921 = NL + "\t\treturn ";
  protected final String TEXT_922 = " != null && ((";
  protected final String TEXT_923 = ".Unsettable)";
  protected final String TEXT_924 = ").isSet();";
  protected final String TEXT_925 = NL + "\t\treturn eVirtualIsSet(";
  protected final String TEXT_926 = ");";
  protected final String TEXT_927 = NL + "\t\treturn (";
  protected final String TEXT_928 = " & ";
  protected final String TEXT_929 = "_ESETFLAG) != 0;";
  protected final String TEXT_930 = NL + "\t\treturn ";
  protected final String TEXT_931 = "ESet;";
  protected final String TEXT_932 = NL + "\t\treturn !((";
  protected final String TEXT_933 = ".Internal)((";
  protected final String TEXT_934 = ".Internal.Wrapper)get";
  protected final String TEXT_935 = "()).featureMap()).isEmpty(";
  protected final String TEXT_936 = ");";
  protected final String TEXT_937 = NL + "\t\treturn !((";
  protected final String TEXT_938 = ".Internal)get";
  protected final String TEXT_939 = "()).isEmpty(";
  protected final String TEXT_940 = ");";
  protected final String TEXT_941 = NL + "\t\t// TODO: implement this method to return whether the '";
  protected final String TEXT_942 = "' ";
  protected final String TEXT_943 = " is set" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_944 = NL + "\t}" + NL;
  protected final String TEXT_945 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->";
  protected final String TEXT_946 = NL + "\t * <!-- begin-model-doc -->" + NL + "\t * ";
  protected final String TEXT_947 = NL + "\t * <!-- end-model-doc -->";
  protected final String TEXT_948 = NL + "\t * @model ";
  protected final String TEXT_949 = NL + "\t *        ";
  protected final String TEXT_950 = NL + "\t * @model";
  protected final String TEXT_951 = NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_952 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_953 = NL + "\t";
  protected final String TEXT_954 = " ";
  protected final String TEXT_955 = "(";
  protected final String TEXT_956 = ")";
  protected final String TEXT_957 = ";" + NL;
  protected final String TEXT_958 = NL + "\tpublic ";
  protected final String TEXT_959 = " ";
  protected final String TEXT_960 = "(";
  protected final String TEXT_961 = ")";
  protected final String TEXT_962 = NL + "\t{";
  protected final String TEXT_963 = NL + "\t\t";
  protected final String TEXT_964 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// -> specify the condition that violates the invariant" + NL + "\t\t// -> verify the details of the diagnostic, including severity and message" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tif (false)" + NL + "\t\t{" + NL + "\t\t\tif (";
  protected final String TEXT_965 = " != null)" + NL + "\t\t\t{" + NL + "\t\t\t\t";
  protected final String TEXT_966 = ".add" + NL + "\t\t\t\t\t(new ";
  protected final String TEXT_967 = NL + "\t\t\t\t\t\t(";
  protected final String TEXT_968 = ".ERROR," + NL + "\t\t\t\t\t\t ";
  protected final String TEXT_969 = ".DIAGNOSTIC_SOURCE," + NL + "\t\t\t\t\t\t ";
  protected final String TEXT_970 = ".";
  protected final String TEXT_971 = "," + NL + "\t\t\t\t\t\t ";
  protected final String TEXT_972 = ".INSTANCE.getString(\"_UI_GenericInvariant_diagnostic\", new Object[] { \"";
  protected final String TEXT_973 = "\", ";
  protected final String TEXT_974 = ".getObjectLabel(this, ";
  protected final String TEXT_975 = ") }),";
  protected final String TEXT_976 = NL + "\t\t\t\t\t\t new Object [] { this }));" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\treturn true;";
  protected final String TEXT_977 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tthrow new UnsupportedOperationException();";
  protected final String TEXT_978 = NL + "\t}" + NL;
  protected final String TEXT_979 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_980 = " eInverseAdd(";
  protected final String TEXT_981 = " otherEnd, int featureID, ";
  protected final String TEXT_982 = " msgs)" + NL + "\t{" + NL + "\t\tswitch (featureID)" + NL + "\t\t{";
  protected final String TEXT_983 = NL + "\t\t\tcase ";
  protected final String TEXT_984 = ":";
  protected final String TEXT_985 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_986 = ")((";
  protected final String TEXT_987 = ".InternalMapView)";
  protected final String TEXT_988 = "()).eMap()).basicAdd(otherEnd, msgs);";
  protected final String TEXT_989 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_990 = ")";
  protected final String TEXT_991 = "()).basicAdd(otherEnd, msgs);";
  protected final String TEXT_992 = NL + "\t\t\t\tif (eInternalContainer() != null)" + NL + "\t\t\t\t\tmsgs = eBasicRemoveFromContainer(msgs);";
  protected final String TEXT_993 = NL + "\t\t\t\treturn basicSet";
  protected final String TEXT_994 = "((";
  protected final String TEXT_995 = ")otherEnd, msgs);";
  protected final String TEXT_996 = NL + "\t\t\t\treturn eBasicSetContainer(otherEnd, ";
  protected final String TEXT_997 = ", msgs);";
  protected final String TEXT_998 = NL + "\t\t\t\t";
  protected final String TEXT_999 = " ";
  protected final String TEXT_1000 = " = (";
  protected final String TEXT_1001 = ")eVirtualGet(";
  protected final String TEXT_1002 = ");";
  protected final String TEXT_1003 = NL + "\t\t\t\tif (";
  protected final String TEXT_1004 = " != null)";
  protected final String TEXT_1005 = NL + "\t\t\t\t\tmsgs = ((";
  protected final String TEXT_1006 = ")";
  protected final String TEXT_1007 = ").eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_1008 = ", null, msgs);";
  protected final String TEXT_1009 = NL + "\t\t\t\t\tmsgs = ((";
  protected final String TEXT_1010 = ")";
  protected final String TEXT_1011 = ").eInverseRemove(this, ";
  protected final String TEXT_1012 = ", ";
  protected final String TEXT_1013 = ".class, msgs);";
  protected final String TEXT_1014 = NL + "\t\t\t\treturn basicSet";
  protected final String TEXT_1015 = "((";
  protected final String TEXT_1016 = ")otherEnd, msgs);";
  protected final String TEXT_1017 = NL + "\t\t}";
  protected final String TEXT_1018 = NL + "\t\treturn super.eInverseAdd(otherEnd, featureID, msgs);";
  protected final String TEXT_1019 = NL + "\t\treturn eDynamicInverseAdd(otherEnd, featureID, msgs);";
  protected final String TEXT_1020 = NL + "\t}" + NL;
  protected final String TEXT_1021 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_1022 = " eInverseRemove(";
  protected final String TEXT_1023 = " otherEnd, int featureID, ";
  protected final String TEXT_1024 = " msgs)" + NL + "\t{" + NL + "\t\tswitch (featureID)" + NL + "\t\t{";
  protected final String TEXT_1025 = NL + "\t\t\tcase ";
  protected final String TEXT_1026 = ":";
  protected final String TEXT_1027 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_1028 = ")((";
  protected final String TEXT_1029 = ".InternalMapView)";
  protected final String TEXT_1030 = "()).eMap()).basicRemove(otherEnd, msgs);";
  protected final String TEXT_1031 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_1032 = ")((";
  protected final String TEXT_1033 = ".Internal.Wrapper)";
  protected final String TEXT_1034 = "()).featureMap()).basicRemove(otherEnd, msgs);";
  protected final String TEXT_1035 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_1036 = ")";
  protected final String TEXT_1037 = "()).basicRemove(otherEnd, msgs);";
  protected final String TEXT_1038 = NL + "\t\t\t\treturn eBasicSetContainer(null, ";
  protected final String TEXT_1039 = ", msgs);";
  protected final String TEXT_1040 = NL + "\t\t\t\treturn basicUnset";
  protected final String TEXT_1041 = "(msgs);";
  protected final String TEXT_1042 = NL + "\t\t\t\treturn basicSet";
  protected final String TEXT_1043 = "(null, msgs);";
  protected final String TEXT_1044 = NL + "\t\t}";
  protected final String TEXT_1045 = NL + "\t\treturn super.eInverseRemove(otherEnd, featureID, msgs);";
  protected final String TEXT_1046 = NL + "\t\treturn eDynamicInverseRemove(otherEnd, featureID, msgs);";
  protected final String TEXT_1047 = NL + "\t}" + NL;
  protected final String TEXT_1048 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_1049 = " eBasicRemoveFromContainerFeature(";
  protected final String TEXT_1050 = " msgs)" + NL + "\t{" + NL + "\t\tswitch (eContainerFeatureID)" + NL + "\t\t{";
  protected final String TEXT_1051 = NL + "\t\t\tcase ";
  protected final String TEXT_1052 = ":" + NL + "\t\t\t\treturn eInternalContainer().eInverseRemove(this, ";
  protected final String TEXT_1053 = ", ";
  protected final String TEXT_1054 = ".class, msgs);";
  protected final String TEXT_1055 = NL + "\t\t}";
  protected final String TEXT_1056 = NL + "\t\treturn super.eBasicRemoveFromContainerFeature(msgs);";
  protected final String TEXT_1057 = NL + "\t\treturn eDynamicBasicRemoveFromContainer(msgs);";
  protected final String TEXT_1058 = NL + "\t}" + NL;
  protected final String TEXT_1059 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object eGet(int featureID, boolean resolve, boolean coreType)" + NL + "\t{" + NL + "\t\tswitch (featureID)" + NL + "\t\t{";
  protected final String TEXT_1060 = NL + "\t\t\tcase ";
  protected final String TEXT_1061 = ":";
  protected final String TEXT_1062 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1063 = "() ? Boolean.TRUE : Boolean.FALSE;";
  protected final String TEXT_1064 = NL + "\t\t\t\treturn new ";
  protected final String TEXT_1065 = "(";
  protected final String TEXT_1066 = "());";
  protected final String TEXT_1067 = NL + "\t\t\t\tif (resolve) return ";
  protected final String TEXT_1068 = "();" + NL + "\t\t\t\treturn basicGet";
  protected final String TEXT_1069 = "();";
  protected final String TEXT_1070 = NL + "\t\t\t\tif (coreType) return ((";
  protected final String TEXT_1071 = ".InternalMapView)";
  protected final String TEXT_1072 = "()).eMap();" + NL + "\t\t\t\telse return ";
  protected final String TEXT_1073 = "();";
  protected final String TEXT_1074 = NL + "\t\t\t\tif (coreType) return ";
  protected final String TEXT_1075 = "();" + NL + "\t\t\t\telse return ";
  protected final String TEXT_1076 = "().map();";
  protected final String TEXT_1077 = NL + "\t\t\t\tif (coreType) return ((";
  protected final String TEXT_1078 = ".Internal.Wrapper)";
  protected final String TEXT_1079 = "()).featureMap();" + NL + "\t\t\t\treturn ";
  protected final String TEXT_1080 = "();";
  protected final String TEXT_1081 = NL + "\t\t\t\tif (coreType) return ";
  protected final String TEXT_1082 = "();" + NL + "\t\t\t\treturn ((";
  protected final String TEXT_1083 = ".Internal)";
  protected final String TEXT_1084 = "()).getWrapper();";
  protected final String TEXT_1085 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1086 = "();";
  protected final String TEXT_1087 = NL + "\t\t}";
  protected final String TEXT_1088 = NL + "\t\treturn super.eGet(featureID, resolve, coreType);";
  protected final String TEXT_1089 = NL + "\t\treturn eDynamicGet(featureID, resolve, coreType);";
  protected final String TEXT_1090 = NL + "\t}" + NL;
  protected final String TEXT_1091 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void eSet(int featureID, Object newValue)" + NL + "\t{" + NL + "\t\tswitch (featureID)" + NL + "\t\t{";
  protected final String TEXT_1092 = NL + "\t\t\tcase ";
  protected final String TEXT_1093 = ":";
  protected final String TEXT_1094 = NL + "\t\t\t\t((";
  protected final String TEXT_1095 = ".Internal)((";
  protected final String TEXT_1096 = ".Internal.Wrapper)";
  protected final String TEXT_1097 = "()).featureMap()).set(newValue);";
  protected final String TEXT_1098 = NL + "\t\t\t\t((";
  protected final String TEXT_1099 = ".Internal)";
  protected final String TEXT_1100 = "()).set(newValue);";
  protected final String TEXT_1101 = NL + "\t\t\t\t((";
  protected final String TEXT_1102 = ".Setting)((";
  protected final String TEXT_1103 = ".InternalMapView)";
  protected final String TEXT_1104 = "()).eMap()).set(newValue);";
  protected final String TEXT_1105 = NL + "\t\t\t\t((";
  protected final String TEXT_1106 = ".Setting)";
  protected final String TEXT_1107 = "()).set(newValue);";
  protected final String TEXT_1108 = NL + "\t\t\t\t";
  protected final String TEXT_1109 = "().clear();" + NL + "\t\t\t\t";
  protected final String TEXT_1110 = "().addAll((";
  protected final String TEXT_1111 = ")newValue);";
  protected final String TEXT_1112 = NL + "\t\t\t\tset";
  protected final String TEXT_1113 = "(((";
  protected final String TEXT_1114 = ")newValue).";
  protected final String TEXT_1115 = "());";
  protected final String TEXT_1116 = NL + "\t\t\t\tset";
  protected final String TEXT_1117 = "((";
  protected final String TEXT_1118 = ")newValue);";
  protected final String TEXT_1119 = NL + "\t\t\t\treturn;";
  protected final String TEXT_1120 = NL + "\t\t}";
  protected final String TEXT_1121 = NL + "\t\tsuper.eSet(featureID, newValue);";
  protected final String TEXT_1122 = NL + "\t\teDynamicSet(featureID, newValue);";
  protected final String TEXT_1123 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void eUnset(int featureID)" + NL + "\t{" + NL + "\t\tswitch (featureID)" + NL + "\t\t{";
  protected final String TEXT_1124 = NL + "\t\t\tcase ";
  protected final String TEXT_1125 = ":";
  protected final String TEXT_1126 = NL + "\t\t\t\t((";
  protected final String TEXT_1127 = ".Internal.Wrapper)";
  protected final String TEXT_1128 = "()).featureMap().clear();";
  protected final String TEXT_1129 = NL + "\t\t\t\t";
  protected final String TEXT_1130 = "().clear();";
  protected final String TEXT_1131 = NL + "\t\t\t\tunset";
  protected final String TEXT_1132 = "();";
  protected final String TEXT_1133 = NL + "\t\t\t\tset";
  protected final String TEXT_1134 = "((";
  protected final String TEXT_1135 = ")null);";
  protected final String TEXT_1136 = NL + "\t\t\t\tset";
  protected final String TEXT_1137 = "(";
  protected final String TEXT_1138 = "_EDEFAULT);";
  protected final String TEXT_1139 = NL + "\t\t\t\treturn;";
  protected final String TEXT_1140 = NL + "\t\t}";
  protected final String TEXT_1141 = NL + "\t\tsuper.eUnset(featureID);";
  protected final String TEXT_1142 = NL + "\t\teDynamicUnset(featureID);";
  protected final String TEXT_1143 = NL + "\t}" + NL;
  protected final String TEXT_1144 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean eIsSet(int featureID)" + NL + "\t{\t" + NL + "//UMA-->" + NL + "\t\t";
  protected final String TEXT_1145 = " feature = getFeatureWithOverridenDefaultValue(featureID);" + NL + "\t\tif(feature != null) {" + NL + "\t\t\treturn isFeatureWithOverridenDefaultValueSet(feature);" + NL + "\t\t}" + NL + "//UMA<--\t\t" + NL + "\t\tswitch (featureID)" + NL + "\t\t{";
  protected final String TEXT_1146 = NL + "\t\t\tcase ";
  protected final String TEXT_1147 = ":";
  protected final String TEXT_1148 = NL + "\t\t\t\treturn !((";
  protected final String TEXT_1149 = ".Internal.Wrapper)";
  protected final String TEXT_1150 = "()).featureMap().isEmpty();";
  protected final String TEXT_1151 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1152 = " != null && !";
  protected final String TEXT_1153 = ".featureMap().isEmpty();";
  protected final String TEXT_1154 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1155 = " != null && !";
  protected final String TEXT_1156 = ".isEmpty();";
  protected final String TEXT_1157 = NL + "\t\t\t\t";
  protected final String TEXT_1158 = " ";
  protected final String TEXT_1159 = " = (";
  protected final String TEXT_1160 = ")eVirtualGet(";
  protected final String TEXT_1161 = ");" + NL + "\t\t\t\treturn ";
  protected final String TEXT_1162 = " != null && !";
  protected final String TEXT_1163 = ".isEmpty();";
  protected final String TEXT_1164 = NL + "\t\t\t\treturn !";
  protected final String TEXT_1165 = "().isEmpty();";
  protected final String TEXT_1166 = NL + "\t\t\t\treturn isSet";
  protected final String TEXT_1167 = "();";
  protected final String TEXT_1168 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1169 = " != null;";
  protected final String TEXT_1170 = NL + "\t\t\t\treturn eVirtualGet(";
  protected final String TEXT_1171 = ") != null;";
  protected final String TEXT_1172 = NL + "\t\t\t\treturn basicGet";
  protected final String TEXT_1173 = "() != null;";
  protected final String TEXT_1174 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1175 = " != null;";
  protected final String TEXT_1176 = NL + "\t\t\t\treturn eVirtualGet(";
  protected final String TEXT_1177 = ") != null;";
  protected final String TEXT_1178 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1179 = "() != null;";
  protected final String TEXT_1180 = NL + "\t\t\t\treturn ((";
  protected final String TEXT_1181 = " & ";
  protected final String TEXT_1182 = "_EFLAG) != 0) != ";
  protected final String TEXT_1183 = "_EDEFAULT;";
  protected final String TEXT_1184 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1185 = " != ";
  protected final String TEXT_1186 = "_EDEFAULT;";
  protected final String TEXT_1187 = NL + "\t\t\t\treturn eVirtualGet(";
  protected final String TEXT_1188 = ", ";
  protected final String TEXT_1189 = "_EDEFAULT) != ";
  protected final String TEXT_1190 = "_EDEFAULT;";
  protected final String TEXT_1191 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1192 = "() != ";
  protected final String TEXT_1193 = "_EDEFAULT;";
  protected final String TEXT_1194 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1195 = "_EDEFAULT == null ? ";
  protected final String TEXT_1196 = " != null : !";
  protected final String TEXT_1197 = "_EDEFAULT.equals(";
  protected final String TEXT_1198 = ");";
  protected final String TEXT_1199 = NL + "\t\t\t\t";
  protected final String TEXT_1200 = " ";
  protected final String TEXT_1201 = " = (";
  protected final String TEXT_1202 = ")eVirtualGet(";
  protected final String TEXT_1203 = ", ";
  protected final String TEXT_1204 = "_EDEFAULT);" + NL + "\t\t\t\treturn ";
  protected final String TEXT_1205 = "_EDEFAULT == null ? ";
  protected final String TEXT_1206 = " != null : !";
  protected final String TEXT_1207 = "_EDEFAULT.equals(";
  protected final String TEXT_1208 = ");";
  protected final String TEXT_1209 = NL + "\t\t\t\treturn ";
  protected final String TEXT_1210 = "_EDEFAULT == null ? ";
  protected final String TEXT_1211 = "() != null : !";
  protected final String TEXT_1212 = "_EDEFAULT.equals(";
  protected final String TEXT_1213 = "());";
  protected final String TEXT_1214 = NL + "\t\t}";
  protected final String TEXT_1215 = NL + "\t\treturn super.eIsSet(featureID);";
  protected final String TEXT_1216 = NL + "\t\treturn eDynamicIsSet(featureID);";
  protected final String TEXT_1217 = NL + "\t}" + NL;
  protected final String TEXT_1218 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass)" + NL + "\t{";
  protected final String TEXT_1219 = NL + "\t\tif (baseClass == ";
  protected final String TEXT_1220 = ".class)" + NL + "\t\t{" + NL + "\t\t\tswitch (derivedFeatureID)" + NL + "\t\t\t{";
  protected final String TEXT_1221 = NL + "\t\t\t\tcase ";
  protected final String TEXT_1222 = ": return ";
  protected final String TEXT_1223 = ";";
  protected final String TEXT_1224 = NL + "\t\t\t\tdefault: return -1;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_1225 = NL + "\t\treturn super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass)" + NL + "\t{";
  protected final String TEXT_1226 = NL + "\t\tif (baseClass == ";
  protected final String TEXT_1227 = ".class)" + NL + "\t\t{" + NL + "\t\t\tswitch (baseFeatureID)" + NL + "\t\t\t{";
  protected final String TEXT_1228 = NL + "\t\t\t\tcase ";
  protected final String TEXT_1229 = ": return ";
  protected final String TEXT_1230 = ";";
  protected final String TEXT_1231 = NL + "\t\t\t\tdefault: return -1;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_1232 = NL + "\t\treturn super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);" + NL + "\t}" + NL;
  protected final String TEXT_1233 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Object[] eVirtualValues()" + NL + "\t{" + NL + "\t\treturn ";
  protected final String TEXT_1234 = ";" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void eSetVirtualValues(Object[] newValues)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1235 = " = newValues;" + NL + "\t}" + NL;
  protected final String TEXT_1236 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected int eVirtualIndexBits(int offset)" + NL + "\t{" + NL + "\t\tswitch (offset)" + NL + "\t\t{";
  protected final String TEXT_1237 = NL + "\t\t\tcase ";
  protected final String TEXT_1238 = " :" + NL + "\t\t\t\treturn ";
  protected final String TEXT_1239 = ";";
  protected final String TEXT_1240 = NL + "\t\t\tdefault :" + NL + "\t\t\t\tthrow new IndexOutOfBoundsException();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void eSetVirtualIndexBits(int offset, int newIndexBits)" + NL + "\t{" + NL + "\t\tswitch (offset)" + NL + "\t\t{";
  protected final String TEXT_1241 = NL + "\t\t\tcase ";
  protected final String TEXT_1242 = " :" + NL + "\t\t\t\t";
  protected final String TEXT_1243 = " = newIndexBits;" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_1244 = NL + "\t\t\tdefault :" + NL + "\t\t\t\tthrow new IndexOutOfBoundsException();" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_1245 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String toString()" + NL + "\t{" + NL + "\t\tif (eIsProxy()) return super.toString();" + NL + "" + NL + "\t\tStringBuffer result = new StringBuffer(super.toString());";
  protected final String TEXT_1246 = NL + "\t\tresult.append(\" (";
  protected final String TEXT_1247 = ": \");";
  protected final String TEXT_1248 = NL + "\t\tresult.append(\", ";
  protected final String TEXT_1249 = ": \");";
  protected final String TEXT_1250 = NL + "\t\tif (eVirtualIsSet(";
  protected final String TEXT_1251 = ")) result.append(eVirtualGet(";
  protected final String TEXT_1252 = ")); else result.append(\"<unset>\");";
  protected final String TEXT_1253 = NL + "\t\tif (";
  protected final String TEXT_1254 = "(";
  protected final String TEXT_1255 = " & ";
  protected final String TEXT_1256 = "_ESETFLAG) != 0";
  protected final String TEXT_1257 = "ESet";
  protected final String TEXT_1258 = ") result.append((";
  protected final String TEXT_1259 = " & ";
  protected final String TEXT_1260 = "_EFLAG) != 0); else result.append(\"<unset>\");";
  protected final String TEXT_1261 = NL + "\t\tif (";
  protected final String TEXT_1262 = "(";
  protected final String TEXT_1263 = " & ";
  protected final String TEXT_1264 = "_ESETFLAG) != 0";
  protected final String TEXT_1265 = "ESet";
  protected final String TEXT_1266 = ") result.append(";
  protected final String TEXT_1267 = "); else result.append(\"<unset>\");";
  protected final String TEXT_1268 = NL + "\t\tresult.append(eVirtualGet(";
  protected final String TEXT_1269 = ", ";
  protected final String TEXT_1270 = "_EDEFAULT";
  protected final String TEXT_1271 = "));";
  protected final String TEXT_1272 = NL + "\t\tresult.append((";
  protected final String TEXT_1273 = " & ";
  protected final String TEXT_1274 = "_EFLAG) != 0);";
  protected final String TEXT_1275 = NL + "\t\tresult.append(";
  protected final String TEXT_1276 = ");";
  protected final String TEXT_1277 = NL + "\t\tresult.append(')');" + NL + "\t\treturn result.toString();" + NL + "\t}" + NL;
  protected final String TEXT_1278 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected int hash = -1;" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getHash()" + NL + "\t{" + NL + "\t\tif (hash == -1)" + NL + "\t\t{" + NL + "\t\t\tObject theKey = getKey();" + NL + "\t\t\thash = (theKey == null ? 0 : theKey.hashCode());" + NL + "\t\t}" + NL + "\t\treturn hash;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setHash(int hash)" + NL + "\t{" + NL + "\t\tthis.hash = hash;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getKey()" + NL + "\t{";
  protected final String TEXT_1279 = NL + "\t\treturn new ";
  protected final String TEXT_1280 = "(getTypedKey());";
  protected final String TEXT_1281 = NL + "\t\treturn getTypedKey();";
  protected final String TEXT_1282 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setKey(Object key)" + NL + "\t{";
  protected final String TEXT_1283 = NL + "\t\tgetTypedKey().addAll((";
  protected final String TEXT_1284 = ")key);";
  protected final String TEXT_1285 = NL + "\t\tsetTypedKey(((";
  protected final String TEXT_1286 = ")key).";
  protected final String TEXT_1287 = "());";
  protected final String TEXT_1288 = NL + "\t\tsetTypedKey((";
  protected final String TEXT_1289 = ")key);";
  protected final String TEXT_1290 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getValue()" + NL + "\t{";
  protected final String TEXT_1291 = NL + "\t\treturn new ";
  protected final String TEXT_1292 = "(getTypedValue());";
  protected final String TEXT_1293 = NL + "\t\treturn getTypedValue();";
  protected final String TEXT_1294 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object setValue(Object value)" + NL + "\t{" + NL + "\t\tObject oldValue = getValue();";
  protected final String TEXT_1295 = NL + "\t\tgetTypedValue().clear();" + NL + "\t\tgetTypedValue().addAll((";
  protected final String TEXT_1296 = ")value);";
  protected final String TEXT_1297 = NL + "\t\tsetTypedValue(((";
  protected final String TEXT_1298 = ")value).";
  protected final String TEXT_1299 = "());";
  protected final String TEXT_1300 = NL + "\t\tsetTypedValue((";
  protected final String TEXT_1301 = ")value);";
  protected final String TEXT_1302 = NL + "\t\treturn oldValue;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_1303 = " getEMap()" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_1304 = " container = eContainer();" + NL + "\t\treturn container == null ? null : (";
  protected final String TEXT_1305 = ")container.eGet(eContainmentFeature());" + NL + "\t}" + NL;
  protected final String TEXT_1306 = NL + "} //";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
/**
 * <copyright>
 *
 * Copyright (c) 2002-2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 */

    final GenClass genClass = (GenClass)((Object[])argument)[0]; final GenPackage genPackage = genClass.getGenPackage(); final GenModel genModel=genPackage.getGenModel();
    final boolean isInterface = Boolean.TRUE.equals(((Object[])argument)[1]); final boolean isImplementation = Boolean.TRUE.equals(((Object[])argument)[2]);
    final String publicStaticFinalFlag = isImplementation ? "public static final " : "";
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    if (isInterface) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genPackage.getInterfacePackageName());
    stringBuffer.append(TEXT_4);
    } else {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genPackage.getClassPackageName());
    stringBuffer.append(TEXT_6);
    }
    stringBuffer.append(TEXT_7);
    genModel.markImportLocation(stringBuffer, genPackage);
    stringBuffer.append(TEXT_8);
    if (isInterface) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genClass.getFormattedName());
    stringBuffer.append(TEXT_10);
    if (genClass.hasDocumentation()) {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genClass.getDocumentation(genModel.getIndentation(stringBuffer)));
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    if (!genClass.getGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_14);
    for (Iterator i=genClass.getGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genFeature.isSuppressedGetVisibility()) {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_18);
    }
    }
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    if (!genModel.isSuppressEMFMetaData()) {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(genClass.getClassifierAccessorName());
    stringBuffer.append(TEXT_23);
    }
    if (!genModel.isSuppressEMFModelTags()) { boolean first = true; for (StringTokenizer stringTokenizer = new StringTokenizer(genClass.getModelInfo(), "\n\r"); stringTokenizer.hasMoreTokens(); ) { String modelInfo = stringTokenizer.nextToken(); if (first) { first = false;
    stringBuffer.append(TEXT_24);
    stringBuffer.append(modelInfo);
    } else {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(modelInfo);
    }} if (first) {
    stringBuffer.append(TEXT_26);
    }}
    if (genClass.needsRootExtendsInterfaceExtendsTag()) {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genModel.getImportedName(genModel.getRootExtendsInterface()));
    }
    stringBuffer.append(TEXT_28);
    } else {
    stringBuffer.append(TEXT_29);
    stringBuffer.append(genClass.getFormattedName());
    stringBuffer.append(TEXT_30);
    if (!genClass.getImplementedGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_31);
    for (Iterator i=genClass.getImplementedGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    stringBuffer.append(TEXT_32);
    stringBuffer.append(genClass.getQualifiedClassName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_35);
    }
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    }
    if (isImplementation) {
    stringBuffer.append(TEXT_38);
    if (genClass.isAbstract()) {
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    stringBuffer.append(genClass.getClassName());
    stringBuffer.append(genClass.getClassExtends());
    stringBuffer.append(genClass.getClassImplements());
    } else {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(genClass.getInterfaceName());
    stringBuffer.append(genClass.getInterfaceExtends());
    }
    stringBuffer.append(TEXT_42);
    if (genModel.getCopyrightText() != null) {
    stringBuffer.append(TEXT_43);
    stringBuffer.append(publicStaticFinalFlag);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(genModel.getCopyrightText());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_46);
    }
    if (isImplementation && genModel.getDriverNumber() != null) {
    stringBuffer.append(TEXT_47);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(genModel.getDriverNumber());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_50);
    }
    if (isImplementation && genClass.isJavaIOSerializable()) {
    stringBuffer.append(TEXT_51);
    }
    if (isImplementation && genModel.isVirtualDelegation()) { String eVirtualValuesField = genClass.getEVirtualValuesField();
    if (eVirtualValuesField != null) {
    stringBuffer.append(TEXT_52);
    stringBuffer.append(eVirtualValuesField);
    stringBuffer.append(TEXT_53);
    }
    { List eVirtualIndexBitFields = genClass.getEVirtualIndexBitFields(new ArrayList());
    if (!eVirtualIndexBitFields.isEmpty()) {
    for (Iterator i = eVirtualIndexBitFields.iterator(); i.hasNext();) { String eVirtualIndexBitField = (String)i.next();
    stringBuffer.append(TEXT_54);
    stringBuffer.append(eVirtualIndexBitField);
    stringBuffer.append(TEXT_55);
    }
    }
    }
    }
    if (isImplementation && genClass.isModelRoot() && genModel.isBooleanFlagsEnabled() && genModel.getBooleanFlagsReservedBits() == -1) {
    stringBuffer.append(TEXT_56);
    stringBuffer.append(genModel.getBooleanFlagsField());
    stringBuffer.append(TEXT_57);
    }
    if (isImplementation && !genModel.isReflectiveDelegation()) {
    for (Iterator i=genClass.getDeclaredFieldGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (genFeature.isListType() || genFeature.isReferenceType()) {
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(genFeature.getImportedInternalType());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_64);
    }
    if (genModel.isArrayAccessors() && !genFeature.isFeatureMapType() && !genFeature.isMapType()) {
    stringBuffer.append(TEXT_65);
    stringBuffer.append(genFeature.getGetArrayAccessor());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(genFeature.getGetArrayAccessor());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_71);
    }
    } else {
    if (!genFeature.isVolatile() || !genModel.isReflectiveDelegation() && (!genFeature.hasDelegateFeature() || !genFeature.isUnsettable())) {
    stringBuffer.append(TEXT_72);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(genFeature.getStaticDefaultValue());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(genModel.getNonNLS(genFeature.getStaticDefaultValue()));
    stringBuffer.append(TEXT_80);
    }
    if (genClass.isField(genFeature)) {
    if (genClass.isFlag(genFeature)) {
    if (genClass.getFlagIndex(genFeature) > 31 && genClass.getFlagIndex(genFeature) % 32 == 0) {
    stringBuffer.append(TEXT_81);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_88);
    stringBuffer.append("<< " + genClass.getFlagIndex(genFeature) % 32 );
    stringBuffer.append(TEXT_89);
    } else {
    stringBuffer.append(TEXT_90);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_97);
    }
    }
    }
    if (genClass.isESetField(genFeature)) {
    if (genClass.isESetFlag(genFeature)) {
    if (genClass.getESetFlagIndex(genFeature) > 31 && genClass.getESetFlagIndex(genFeature) % 32 == 0) {
    stringBuffer.append(TEXT_98);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_99);
    }
    stringBuffer.append(TEXT_100);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_102);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_103);
    stringBuffer.append("<< " + genClass.getESetFlagIndex(genFeature) % 32 );
    stringBuffer.append(TEXT_104);
    } else {
    stringBuffer.append(TEXT_105);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_107);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_108);
    }
    }
    }
    //Class/declaredFieldGenFeature.override.javajetinc
    }
    if (isImplementation) {
    stringBuffer.append(TEXT_109);
    stringBuffer.append(genClass.getClassName());
    stringBuffer.append(TEXT_110);
    for (Iterator i=genClass.getFlagGenFeatures("true").iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    stringBuffer.append(TEXT_111);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_113);
    }
    stringBuffer.append(TEXT_114);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(genClass.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_116);
    }
    new Runnable() { public void run() {
    for (Iterator i=(isImplementation ? genClass.getImplementedGenFeatures() : genClass.getDeclaredGenFeatures()).iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (genModel.isArrayAccessors() && genFeature.isListType() && !genFeature.isFeatureMapType() && !genFeature.isMapType()) {
    stringBuffer.append(TEXT_117);
    if (!isImplementation) {
    stringBuffer.append(TEXT_118);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(genFeature.getGetArrayAccessor());
    stringBuffer.append(TEXT_120);
    } else {
    stringBuffer.append(TEXT_121);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(genFeature.getGetArrayAccessor());
    stringBuffer.append(TEXT_123);
    if (genFeature.isVolatile()) {
    stringBuffer.append(TEXT_124);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_128);
    } else {
    stringBuffer.append(TEXT_129);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_130);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_131);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_132);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_135);
    }
    stringBuffer.append(TEXT_136);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_137);
    }
    stringBuffer.append(TEXT_138);
    if (!isImplementation) {
    stringBuffer.append(TEXT_139);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_140);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_141);
    } else {
    stringBuffer.append(TEXT_142);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_143);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_144);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_145);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_146);
    }
    stringBuffer.append(TEXT_147);
    if (!isImplementation) {
    stringBuffer.append(TEXT_148);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_149);
    } else {
    stringBuffer.append(TEXT_150);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_151);
    if (genFeature.isVolatile()) {
    stringBuffer.append(TEXT_152);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_153);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_155);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_156);
    }
    stringBuffer.append(TEXT_157);
    }
    stringBuffer.append(TEXT_158);
    if (!isImplementation) {
    stringBuffer.append(TEXT_159);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_160);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_161);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_162);
    } else {
    stringBuffer.append(TEXT_163);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_164);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_165);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_166);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_168);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_169);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_170);
    }
    stringBuffer.append(TEXT_171);
    if (!isImplementation) {
    stringBuffer.append(TEXT_172);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_173);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_174);
    } else {
    stringBuffer.append(TEXT_175);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_176);
    stringBuffer.append(genFeature.getListItemType());
    stringBuffer.append(TEXT_177);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_178);
    }
    }
    if (genFeature.isGet() && (isImplementation || !genFeature.isSuppressedGetVisibility())) {
    if (isInterface) {
    stringBuffer.append(TEXT_179);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_180);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_181);
    if (genFeature.isListType()) {
    if (genFeature.isMapType()) { GenFeature keyFeature = genFeature.getMapEntryTypeGenClass().getMapEntryKeyFeature(); GenFeature valueFeature = genFeature.getMapEntryTypeGenClass().getMapEntryValueFeature(); 
    stringBuffer.append(TEXT_182);
    if (keyFeature.isListType()) {
    stringBuffer.append(TEXT_183);
    stringBuffer.append(keyFeature.getQualifiedListItemType());
    stringBuffer.append(TEXT_184);
    } else {
    stringBuffer.append(TEXT_185);
    stringBuffer.append(keyFeature.getType());
    stringBuffer.append(TEXT_186);
    }
    stringBuffer.append(TEXT_187);
    if (valueFeature.isListType()) {
    stringBuffer.append(TEXT_188);
    stringBuffer.append(valueFeature.getQualifiedListItemType());
    stringBuffer.append(TEXT_189);
    } else {
    stringBuffer.append(TEXT_190);
    stringBuffer.append(valueFeature.getType());
    stringBuffer.append(TEXT_191);
    }
    stringBuffer.append(TEXT_192);
    } else if (!genFeature.isWrappedFeatureMapType() && !(genModel.isSuppressEMFMetaData() && "org.eclipse.emf.ecore.EObject".equals(genFeature.getQualifiedListItemType()))) {
    stringBuffer.append(TEXT_193);
    stringBuffer.append(genFeature.getQualifiedListItemType());
    stringBuffer.append(TEXT_194);
    }
    } else if (genFeature.isSetDefaultValue()) {
    stringBuffer.append(TEXT_195);
    stringBuffer.append(genFeature.getDefaultValue());
    stringBuffer.append(TEXT_196);
    }
    if (genFeature.getTypeGenEnum() != null) {
    stringBuffer.append(TEXT_197);
    stringBuffer.append(genFeature.getTypeGenEnum().getQualifiedName());
    stringBuffer.append(TEXT_198);
    }
    if (genFeature.isBidirectional() && !genFeature.getReverse().getGenClass().isMapEntry()) { GenFeature reverseGenFeature = genFeature.getReverse(); 
    if (!reverseGenFeature.isSuppressedGetVisibility()) {
    stringBuffer.append(TEXT_199);
    stringBuffer.append(reverseGenFeature.getGenClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_200);
    stringBuffer.append(reverseGenFeature.getGetAccessor());
    stringBuffer.append(TEXT_201);
    stringBuffer.append(reverseGenFeature.getFormattedName());
    stringBuffer.append(TEXT_202);
    }
    }
    stringBuffer.append(TEXT_203);
    if (!genFeature.hasDocumentation()) {
    stringBuffer.append(TEXT_204);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_205);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_206);
    }
    stringBuffer.append(TEXT_207);
    if (genFeature.hasDocumentation()) {
    stringBuffer.append(TEXT_208);
    stringBuffer.append(genFeature.getDocumentation(genModel.getIndentation(stringBuffer)));
    stringBuffer.append(TEXT_209);
    }
    stringBuffer.append(TEXT_210);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_211);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_212);
    if (genFeature.getTypeGenEnum() != null) {
    stringBuffer.append(TEXT_213);
    stringBuffer.append(genFeature.getTypeGenEnum().getQualifiedName());
    }
    if (genFeature.isUnsettable()) {
    if (!genFeature.isSuppressedIsSetVisibility()) {
    stringBuffer.append(TEXT_214);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_215);
    }
    if (genFeature.isChangeable() && !genFeature.isSuppressedUnsetVisibility()) {
    stringBuffer.append(TEXT_216);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_217);
    }
    }
    if (genFeature.isChangeable() && !genFeature.isListType() && !genFeature.isSuppressedSetVisibility()) {
    stringBuffer.append(TEXT_218);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_219);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_220);
    }
    if (!genModel.isSuppressEMFMetaData()) {
    stringBuffer.append(TEXT_221);
    stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
    stringBuffer.append(TEXT_222);
    stringBuffer.append(genFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_223);
    }
    if (genFeature.isBidirectional() && !genFeature.getReverse().getGenClass().isMapEntry()) { GenFeature reverseGenFeature = genFeature.getReverse(); 
    if (!reverseGenFeature.isSuppressedGetVisibility()) {
    stringBuffer.append(TEXT_224);
    stringBuffer.append(reverseGenFeature.getGenClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_225);
    stringBuffer.append(reverseGenFeature.getGetAccessor());
    }
    }
    if (!genModel.isSuppressEMFModelTags()) { boolean first = true; for (StringTokenizer stringTokenizer = new StringTokenizer(genFeature.getModelInfo(), "\n\r"); stringTokenizer.hasMoreTokens(); ) { String modelInfo = stringTokenizer.nextToken(); if (first) { first = false;
    stringBuffer.append(TEXT_226);
    stringBuffer.append(modelInfo);
    } else {
    stringBuffer.append(TEXT_227);
    stringBuffer.append(modelInfo);
    }} if (first) {
    stringBuffer.append(TEXT_228);
    }}
    stringBuffer.append(TEXT_229);
    } else {
    stringBuffer.append(TEXT_230);
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_231);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_232);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_233);
    } else {
    stringBuffer.append(TEXT_234);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_235);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_236);
    if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_237);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_238);
    }
    stringBuffer.append(TEXT_239);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_240);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_241);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_242);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_243);
    }
    stringBuffer.append(TEXT_244);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isListType()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_245);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_246);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_247);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_248);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_249);
    }
    stringBuffer.append(TEXT_250);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_251);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_252);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_253);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_254);
    stringBuffer.append(genClass.getListConstructor(genFeature));
    stringBuffer.append(TEXT_255);
    } else {
    stringBuffer.append(TEXT_256);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_257);
    stringBuffer.append(genClass.getListConstructor(genFeature));
    stringBuffer.append(TEXT_258);
    }
    stringBuffer.append(TEXT_259);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes() ? ".map()" : "");
    stringBuffer.append(TEXT_260);
    } else if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_261);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_262);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_263);
    } else {
    if (genFeature.isResolveProxies()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_264);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_265);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_266);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_267);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    if (!genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_268);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_269);
    }
    stringBuffer.append(TEXT_270);
    }
    stringBuffer.append(TEXT_271);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_272);
    stringBuffer.append(genFeature.getSafeNameAsEObject());
    stringBuffer.append(TEXT_273);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_274);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_275);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_276);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_277);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_278);
    stringBuffer.append(genFeature.getNonEObjectInternalTypeCast());
    stringBuffer.append(TEXT_279);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_280);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_281);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_282);
    if (genFeature.isEffectiveContains()) {
    stringBuffer.append(TEXT_283);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_284);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_285);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_286);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_287);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_288);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_289);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_290);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_291);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_292);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_293);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_294);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_295);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_296);
    }
    stringBuffer.append(TEXT_297);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_298);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_299);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_300);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_301);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_302);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_303);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_304);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_305);
    }
    stringBuffer.append(TEXT_306);
    } else if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_307);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_308);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_309);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_310);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_311);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_312);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_313);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_314);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_315);
    }
    stringBuffer.append(TEXT_316);
    }
    if (!genFeature.isResolveProxies() && genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_317);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_318);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    if (!genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_319);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_320);
    }
    stringBuffer.append(TEXT_321);
    } else if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_322);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_323);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_324);
    } else {
    stringBuffer.append(TEXT_325);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_326);
    }
    }
    } else {//volatile
    if (genFeature.isResolveProxies() && !genFeature.isListType()) {
    stringBuffer.append(TEXT_327);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_328);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_329);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_330);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_331);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_332);
    stringBuffer.append(genFeature.getNonEObjectInternalTypeCast());
    stringBuffer.append(TEXT_333);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_334);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_335);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_336);
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
    if (genFeature.isFeatureMapType()) {
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_337);
    stringBuffer.append(genFeature.getImportedEffectiveFeatureMapWrapperClass());
    stringBuffer.append(TEXT_338);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_339);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_340);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_341);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_342);
    } else {
    stringBuffer.append(TEXT_343);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_344);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_345);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_346);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_347);
    }
    } else if (genFeature.isListType()) {
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_348);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_349);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_350);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_351);
    } else {
    stringBuffer.append(TEXT_352);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_353);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_354);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_355);
    }
    } else {
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_356);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_357);
    }
    stringBuffer.append(TEXT_358);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_359);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_360);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_361);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_362);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_363);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_364);
    }
    stringBuffer.append(TEXT_365);
    } else {
    stringBuffer.append(TEXT_366);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_367);
    }
    stringBuffer.append(TEXT_368);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_369);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_370);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_371);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_372);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_373);
    }
    stringBuffer.append(TEXT_374);
    }
    }
    } else {
    stringBuffer.append(TEXT_375);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_376);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_377);
    if (genFeature.isListType()) {
    stringBuffer.append(TEXT_378);
    if (genFeature.isMapType()) {
    stringBuffer.append(TEXT_379);
    } else if (genFeature.isFeatureMapType()) {
    stringBuffer.append(TEXT_380);
    } else {
    stringBuffer.append(TEXT_381);
    }
    stringBuffer.append(TEXT_382);
    }
    stringBuffer.append(TEXT_383);
    //Class/getGenFeature.todo.override.javajetinc
    }
    }
    stringBuffer.append(TEXT_384);
    }
    //Class/getGenFeature.override.javajetinc
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicGet()) {
    stringBuffer.append(TEXT_385);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_386);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_387);
    if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_388);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_389);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_390);
    } else if (!genFeature.isVolatile()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_391);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_392);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_393);
    } else {
    stringBuffer.append(TEXT_394);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_395);
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_396);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_397);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_398);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_399);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_400);
    } else {
    stringBuffer.append(TEXT_401);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_402);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_403);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_404);
    }
    } else {
    stringBuffer.append(TEXT_405);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_406);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_407);
    //Class/basicGetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_408);
    //Class/basicGetGenFeature.override.javajetinc
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicSet()) {
    stringBuffer.append(TEXT_409);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_410);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_411);
    stringBuffer.append(genFeature.getImportedInternalType());
    stringBuffer.append(TEXT_412);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_413);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_414);
    if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_415);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_416);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_417);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_418);
    stringBuffer.append(TEXT_419);
    } else if (!genFeature.isVolatile()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_420);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_421);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_422);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_423);
    } else {
    stringBuffer.append(TEXT_424);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_425);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_426);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_427);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_428);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_429);
    }
    if (genFeature.isUnsettable()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_430);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_431);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_432);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_433);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_434);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_435);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_436);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_437);
    } else {
    stringBuffer.append(TEXT_438);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_439);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_440);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_441);
    }
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_442);
    if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_443);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_444);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_445);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_446);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_447);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_448);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_449);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_450);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_451);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_452);
    } else {
    stringBuffer.append(TEXT_453);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_454);
    }
    stringBuffer.append(TEXT_455);
    } else {
    stringBuffer.append(TEXT_456);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_457);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_458);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_459);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_460);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_461);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_462);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_463);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_464);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_465);
    }
    stringBuffer.append(TEXT_466);
    }
    stringBuffer.append(TEXT_467);
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_468);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_469);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_470);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_471);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_472);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_473);
    } else {
    stringBuffer.append(TEXT_474);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_475);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_476);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_477);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_478);
    }
    } else {
    stringBuffer.append(TEXT_479);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_480);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_481);
    //Class/basicSetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_482);
    //Class/basicSetGenFeature.override.javajetinc
    }
    if (genFeature.isSet() && (isImplementation || !genFeature.isSuppressedSetVisibility())) {
    if (isInterface) { 
    stringBuffer.append(TEXT_483);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_484);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_485);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_486);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_487);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_488);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_489);
    if (genFeature.isEnumType()) {
    stringBuffer.append(TEXT_490);
    stringBuffer.append(genFeature.getTypeGenEnum().getQualifiedName());
    }
    if (genFeature.isUnsettable()) {
    if (!genFeature.isSuppressedIsSetVisibility()) {
    stringBuffer.append(TEXT_491);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_492);
    }
    if (!genFeature.isSuppressedUnsetVisibility()) {
    stringBuffer.append(TEXT_493);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_494);
    }
    }
    stringBuffer.append(TEXT_495);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_496);
    } else {
    stringBuffer.append(TEXT_497);
    }
    if (!isImplementation) { 
    stringBuffer.append(TEXT_498);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_499);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_500);
    } else {
    stringBuffer.append(TEXT_501);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_502);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_503);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_504);
    if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_505);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_506);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_507);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_508);
    }
    stringBuffer.append(TEXT_509);
    stringBuffer.append(genFeature.getCapName());
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_510);
    }
    stringBuffer.append(TEXT_511);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isContainer()) { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_512);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_513);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_514);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_515);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.EcoreUtil"));
    stringBuffer.append(TEXT_516);
    stringBuffer.append(genFeature.getEObjectCast());
    stringBuffer.append(TEXT_517);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_518);
    stringBuffer.append(genModel.getImportedName("java.lang.IllegalArgumentException"));
    stringBuffer.append(TEXT_519);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_520);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_521);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_522);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_523);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_524);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_525);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_526);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_527);
    stringBuffer.append(genFeature.getInternalTypeCast());
    stringBuffer.append(TEXT_528);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_529);
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_530);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_531);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_532);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_533);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_534);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_535);
    }
    } else if (genFeature.isBidirectional() || genFeature.isEffectiveContains()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_536);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_537);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_538);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_539);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_540);
    }
    stringBuffer.append(TEXT_541);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_542);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_543);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_544);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_545);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_546);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_547);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_548);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_549);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_550);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_551);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_552);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_553);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_554);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_555);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_556);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_557);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_558);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_559);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_560);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_561);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_562);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_563);
    }
    stringBuffer.append(TEXT_564);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_565);
    stringBuffer.append(genFeature.getInternalTypeCast());
    stringBuffer.append(TEXT_566);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_567);
    if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_568);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_569);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_570);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_571);
    } else if (genClass.isESetFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_572);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_573);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_574);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_575);
    }
    stringBuffer.append(TEXT_576);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_577);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_578);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_579);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_580);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_581);
    }
    stringBuffer.append(TEXT_582);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_583);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_584);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_585);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_586);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_587);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_588);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_589);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_590);
    }
    stringBuffer.append(TEXT_591);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_592);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_593);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_594);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_595);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_596);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_597);
    }
    }
    } else {
    if (genClass.isFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_598);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_599);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_600);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_601);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_602);
    }
    stringBuffer.append(TEXT_603);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_604);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_605);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_606);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_607);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_608);
    } else {
    if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_609);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_610);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_611);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_612);
    }
    }
    if (genFeature.isEnumType()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_613);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_614);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_615);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_616);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_617);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_618);
    } else {
    stringBuffer.append(TEXT_619);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_620);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_621);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_622);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_623);
    }
    } else {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_624);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_625);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_626);
    stringBuffer.append(genFeature.getInternalTypeCast());
    stringBuffer.append(TEXT_627);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_628);
    } else {
    stringBuffer.append(TEXT_629);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_630);
    stringBuffer.append(genFeature.getInternalTypeCast());
    stringBuffer.append(TEXT_631);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_632);
    }
    }
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_633);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_634);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_635);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_636);
    }
    }
    if (genFeature.isUnsettable()) {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_637);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_638);
    } else if (genClass.isESetFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_639);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_640);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_641);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_642);
    }
    stringBuffer.append(TEXT_643);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_644);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_645);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_646);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_647);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_648);
    }
    stringBuffer.append(TEXT_649);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_650);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_651);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_652);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_653);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_654);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_655);
    if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_656);
    } else {
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_657);
    }
    stringBuffer.append(TEXT_658);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_659);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_660);
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_661);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(genFeature.getSafeName());
    }
    stringBuffer.append(TEXT_662);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_663);
    } else {
    stringBuffer.append(TEXT_664);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_665);
    }
    stringBuffer.append(TEXT_666);
    }
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_667);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_668);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_669);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_670);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_671);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_672);
    if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_673);
    } else {
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_674);
    }
    stringBuffer.append(TEXT_675);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_676);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_677);
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_678);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(genFeature.getSafeName());
    }
    stringBuffer.append(TEXT_679);
    }
    }
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_680);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_681);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_682);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_683);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_684);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_685);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_686);
    }
    stringBuffer.append(TEXT_687);
    stringBuffer.append(genFeature.getCapName());
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_688);
    }
    stringBuffer.append(TEXT_689);
    } else {
    stringBuffer.append(TEXT_690);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_691);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_692);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_693);
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_694);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_695);
    }
    stringBuffer.append(TEXT_696);
    stringBuffer.append(genFeature.getCapName());
    if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_697);
    }
    stringBuffer.append(TEXT_698);
    }
    } else {
    stringBuffer.append(TEXT_699);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_700);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_701);
    //Class/setGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_702);
    }
    //Class/setGenFeature.override.javajetinc
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicUnset()) {
    stringBuffer.append(TEXT_703);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_704);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_705);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_706);
    if (!genFeature.isVolatile()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_707);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_708);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_709);
    } else {
    stringBuffer.append(TEXT_710);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_711);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_712);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_713);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_714);
    }
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_715);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_716);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_717);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_718);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_719);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_720);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_721);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_722);
    } else {
    stringBuffer.append(TEXT_723);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_724);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_725);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_726);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_727);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_728);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_729);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_730);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_731);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_732);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_733);
    } else {
    stringBuffer.append(TEXT_734);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_735);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_736);
    } else {
    stringBuffer.append(TEXT_737);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_738);
    }
    stringBuffer.append(TEXT_739);
    }
    } else {
    stringBuffer.append(TEXT_740);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_741);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_742);
    //Class/basicUnsetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_743);
    //Class.basicUnsetGenFeature.override.javajetinc
    }
    if (genFeature.isUnset() && (isImplementation || !genFeature.isSuppressedUnsetVisibility())) {
    if (isInterface) {
    stringBuffer.append(TEXT_744);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_745);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_746);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_747);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_748);
    if (!genFeature.isSuppressedIsSetVisibility()) {
    stringBuffer.append(TEXT_749);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_750);
    }
    stringBuffer.append(TEXT_751);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_752);
    if (!genFeature.isListType() && !genFeature.isSuppressedSetVisibility()) {
    stringBuffer.append(TEXT_753);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_754);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_755);
    }
    stringBuffer.append(TEXT_756);
    } else {
    stringBuffer.append(TEXT_757);
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_758);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_759);
    } else {
    stringBuffer.append(TEXT_760);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_761);
    if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_762);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_763);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isListType()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_764);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_765);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_766);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_767);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_768);
    }
    stringBuffer.append(TEXT_769);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_770);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_771);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_772);
    } else if (genFeature.isBidirectional() || genFeature.isEffectiveContains()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_773);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_774);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_775);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_776);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_777);
    }
    stringBuffer.append(TEXT_778);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_779);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_780);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_781);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_782);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_783);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_784);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_785);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_786);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_787);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_788);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_789);
    }
    stringBuffer.append(TEXT_790);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_791);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_792);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_793);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_794);
    } else if (genClass.isESetFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_795);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_796);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_797);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_798);
    }
    stringBuffer.append(TEXT_799);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_800);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_801);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_802);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_803);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_804);
    }
    stringBuffer.append(TEXT_805);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_806);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_807);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_808);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_809);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_810);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_811);
    }
    stringBuffer.append(TEXT_812);
    } else {
    if (genClass.isFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_813);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_814);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_815);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_816);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_817);
    }
    } else if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_818);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_819);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_820);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_821);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_822);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_823);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_824);
    }
    }
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_825);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_826);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_827);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_828);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_829);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_830);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_831);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_832);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_833);
    }
    }
    if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_834);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_835);
    if (!genModel.isVirtualDelegation()) {
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_836);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_837);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_838);
    } else {
    stringBuffer.append(TEXT_839);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_840);
    }
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_841);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_842);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_843);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_844);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_845);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_846);
    } else {
    stringBuffer.append(TEXT_847);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_848);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_849);
    } else {
    stringBuffer.append(TEXT_850);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_851);
    }
    stringBuffer.append(TEXT_852);
    }
    } else {
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_853);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_854);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_855);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_856);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_857);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_858);
    } else if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_859);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_860);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_861);
    }
    if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_862);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_863);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_864);
    } else {
    stringBuffer.append(TEXT_865);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_866);
    }
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_867);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_868);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_869);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_870);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_871);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_872);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_873);
    } else {
    stringBuffer.append(TEXT_874);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_875);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_876);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_877);
    } else {
    stringBuffer.append(TEXT_878);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_879);
    }
    stringBuffer.append(TEXT_880);
    }
    }
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_881);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_882);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_883);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_884);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_885);
    } else {
    stringBuffer.append(TEXT_886);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_887);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_888);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_889);
    }
    } else {
    stringBuffer.append(TEXT_890);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_891);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_892);
    //Class/unsetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_893);
    }
    //Class/unsetGenFeature.override.javajetinc
    }
    if (genFeature.isIsSet() && (isImplementation || !genFeature.isSuppressedIsSetVisibility())) {
    if (isInterface) {
    stringBuffer.append(TEXT_894);
    stringBuffer.append(genClass.getQualifiedInterfaceName());
    stringBuffer.append(TEXT_895);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_896);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_897);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_898);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_899);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_900);
    if (genFeature.isChangeable() && !genFeature.isSuppressedUnsetVisibility()) {
    stringBuffer.append(TEXT_901);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_902);
    }
    stringBuffer.append(TEXT_903);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_904);
    if (!genFeature.isListType() && genFeature.isChangeable() && !genFeature.isSuppressedSetVisibility()) {
    stringBuffer.append(TEXT_905);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_906);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_907);
    }
    stringBuffer.append(TEXT_908);
    } else {
    stringBuffer.append(TEXT_909);
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_910);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_911);
    } else {
    stringBuffer.append(TEXT_912);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_913);
    if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_914);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_915);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isListType()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_916);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_917);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_918);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_919);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_920);
    }
    stringBuffer.append(TEXT_921);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_922);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_923);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_924);
    } else {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_925);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_926);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_927);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_928);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_929);
    } else {
    stringBuffer.append(TEXT_930);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_931);
    }
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_932);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_933);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_934);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_935);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_936);
    } else {
    stringBuffer.append(TEXT_937);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_938);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_939);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_940);
    }
    } else {
    stringBuffer.append(TEXT_941);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_942);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_943);
    //Class/isSetGenFeature.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_944);
    }
    //Class/isSetGenFeature.override.javajetinc
    }
    //Class/genFeature.override.javajetinc
    }//for
    }}.run();
    for (Iterator i= (isImplementation ? genClass.getImplementedGenOperations() : genClass.getDeclaredGenOperations()).iterator(); i.hasNext();) { GenOperation genOperation = (GenOperation)i.next();
    if (isInterface) {
    stringBuffer.append(TEXT_945);
    if (genOperation.hasDocumentation()) {
    stringBuffer.append(TEXT_946);
    stringBuffer.append(genOperation.getDocumentation(genModel.getIndentation(stringBuffer)));
    stringBuffer.append(TEXT_947);
    }
    if (!genModel.isSuppressEMFModelTags()) { boolean first = true; for (StringTokenizer stringTokenizer = new StringTokenizer(genOperation.getModelInfo(), "\n\r"); stringTokenizer.hasMoreTokens(); ) { String modelInfo = stringTokenizer.nextToken(); if (first) { first = false;
    stringBuffer.append(TEXT_948);
    stringBuffer.append(modelInfo);
    } else {
    stringBuffer.append(TEXT_949);
    stringBuffer.append(modelInfo);
    }} if (first) {
    stringBuffer.append(TEXT_950);
    }}
    stringBuffer.append(TEXT_951);
    } else {
    stringBuffer.append(TEXT_952);
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_953);
    stringBuffer.append(genOperation.getImportedType());
    stringBuffer.append(TEXT_954);
    stringBuffer.append(genOperation.getName());
    stringBuffer.append(TEXT_955);
    stringBuffer.append(genOperation.getParameters());
    stringBuffer.append(TEXT_956);
    stringBuffer.append(genOperation.getThrows());
    stringBuffer.append(TEXT_957);
    } else {
    stringBuffer.append(TEXT_958);
    stringBuffer.append(genOperation.getImportedType());
    stringBuffer.append(TEXT_959);
    stringBuffer.append(genOperation.getName());
    stringBuffer.append(TEXT_960);
    stringBuffer.append(genOperation.getParameters());
    stringBuffer.append(TEXT_961);
    stringBuffer.append(genOperation.getThrows());
    stringBuffer.append(TEXT_962);
    if (genOperation.hasBody()) {
    stringBuffer.append(TEXT_963);
    stringBuffer.append(genOperation.getBody(genModel.getIndentation(stringBuffer)));
    } else if (genOperation.isInvariant()) {GenClass opClass = genOperation.getGenClass(); String diagnostics = ((GenParameter)genOperation.getGenParameters().get(0)).getName(); String context = ((GenParameter)genOperation.getGenParameters().get(1)).getName();
    stringBuffer.append(TEXT_964);
    stringBuffer.append(diagnostics);
    stringBuffer.append(TEXT_965);
    stringBuffer.append(diagnostics);
    stringBuffer.append(TEXT_966);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicDiagnostic"));
    stringBuffer.append(TEXT_967);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
    stringBuffer.append(TEXT_968);
    stringBuffer.append(opClass.getGenPackage().getImportedValidatorClassName());
    stringBuffer.append(TEXT_969);
    stringBuffer.append(opClass.getGenPackage().getImportedValidatorClassName());
    stringBuffer.append(TEXT_970);
    stringBuffer.append(opClass.getOperationID(genOperation));
    stringBuffer.append(TEXT_971);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.plugin.EcorePlugin"));
    stringBuffer.append(TEXT_972);
    stringBuffer.append(genOperation.getName());
    stringBuffer.append(TEXT_973);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.EObjectValidator"));
    stringBuffer.append(TEXT_974);
    stringBuffer.append(context);
    stringBuffer.append(TEXT_975);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(genModel.getNonNLS(2));
    stringBuffer.append(TEXT_976);
    } else {
    stringBuffer.append(TEXT_977);
    //Class/implementedGenOperation.todo.override.javajetinc
    }
    stringBuffer.append(TEXT_978);
    }
    //Class/implementedGenOperation.override.javajetinc
    }//for
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEInverseAddGenFeatures())) {
    stringBuffer.append(TEXT_979);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_980);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_981);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_982);
    for (Iterator i=genClass.getEInverseAddGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_983);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_984);
    if (genFeature.isListType()) {
    if (genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes()) {
    stringBuffer.append(TEXT_985);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_986);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_987);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_988);
    } else {
    stringBuffer.append(TEXT_989);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_990);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_991);
    }
    } else if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_992);
    if (genFeature.isBasicSet()) {
    stringBuffer.append(TEXT_993);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_994);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_995);
    } else {
    stringBuffer.append(TEXT_996);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_997);
    }
    } else {
    if (genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_998);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_999);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1002);
    }
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1004);
    if (genFeature.isEffectiveContains()) {
    stringBuffer.append(TEXT_1005);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1008);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1011);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_1012);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_1013);
    }
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1016);
    }
    }
    }
    stringBuffer.append(TEXT_1017);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1018);
    } else {
    stringBuffer.append(TEXT_1019);
    }
    stringBuffer.append(TEXT_1020);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEInverseRemoveGenFeatures())) {
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_1024);
    for (Iterator i=genClass.getEInverseRemoveGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1026);
    if (genFeature.isListType()) {
    if (genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes()) {
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1030);
    } else if (genFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1034);
    } else {
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1037);
    }
    } else if (genFeature.isContainer() && !genFeature.isBasicSet()) {
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1039);
    } else if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1041);
    } else {
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1043);
    }
    }
    }
    stringBuffer.append(TEXT_1044);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1045);
    } else {
    stringBuffer.append(TEXT_1046);
    }
    stringBuffer.append(TEXT_1047);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getEBasicRemoveFromContainerGenFeatures())) {
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_1050);
    for (Iterator i=genClass.getEBasicRemoveFromContainerGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(targetClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_1054);
    }
    }
    stringBuffer.append(TEXT_1055);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1056);
    } else {
    stringBuffer.append(TEXT_1057);
    }
    stringBuffer.append(TEXT_1058);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && !genClass.getImplementedGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_1059);
    for (Iterator i=genClass.getAllGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_1060);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1061);
    if (genFeature.isPrimitiveType()) {
    if (genFeature.isBooleanType()) {
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1063);
    } else {
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1066);
    }
    } else if (genFeature.isResolveProxies() && !genFeature.isListType()) {
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1068);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1069);
    } else if (genFeature.isMapType()) {
    if (genFeature.isEffectiveSuppressEMFTypes()) {
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1073);
    } else {
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1075);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1076);
    }
    } else if (genFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_1077);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_1078);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1080);
    } else if (genFeature.isFeatureMapType()) {
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_1083);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1084);
    } else {
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1086);
    }
    }
    }
    stringBuffer.append(TEXT_1087);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1088);
    } else {
    stringBuffer.append(TEXT_1089);
    }
    stringBuffer.append(TEXT_1090);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genClass.implementsAny(genClass.getESetGenFeatures())) {
    stringBuffer.append(TEXT_1091);
    for (Iterator i=genClass.getESetGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_1092);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1093);
    if (genFeature.isListType()) {
    if (genFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1097);
    } else if (genFeature.isFeatureMapType()) {
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1100);
    } else if (genFeature.isMapType()) {
    if (genFeature.isEffectiveSuppressEMFTypes()) {
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1104);
    } else {
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1107);
    }
    } else {
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(genModel.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_1111);
    }
    } else if (genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(genFeature.getObjectType());
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_1115);
    } else {
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1118);
    }
    stringBuffer.append(TEXT_1119);
    }
    }
    stringBuffer.append(TEXT_1120);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1121);
    } else {
    stringBuffer.append(TEXT_1122);
    }
    stringBuffer.append(TEXT_1123);
    for (Iterator i=genClass.getESetGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1125);
    if (genFeature.isListType() && !genFeature.isUnsettable()) {
    if (genFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1128);
    } else {
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1130);
    }
    } else if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_1131);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1132);
    } else if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1135);
    } else {
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1138);
    }
    stringBuffer.append(TEXT_1139);
    }
    }
    stringBuffer.append(TEXT_1140);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1141);
    } else {
    stringBuffer.append(TEXT_1142);
    }
    stringBuffer.append(TEXT_1143);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && !genClass.getImplementedGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_1145);
    for (Iterator i=genClass.getAllGenFeatures().iterator(); i.hasNext();) { GenFeature genFeature = (GenFeature)i.next();
    if (!genModel.isMinimalReflectiveMethods() || genClass.getImplementedGenFeatures().contains(genFeature)) {
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1147);
    if (genFeature.isListType() && !genFeature.isUnsettable()) {
    if (genFeature.isWrappedFeatureMapType()) {
    if (genFeature.isVolatile()) {
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1150);
    } else {
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1153);
    }
    } else {
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1156);
    } else {
    if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1163);
    } else {
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1165);
    }
    }
    }
    } else if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1167);
    } else if (genFeature.isResolveProxies()) {
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1169);
    } else {
    if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1170);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1171);
    } else {
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_1173);
    }
    }
    } else if (genFeature.isReferenceType()) {
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_1174);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1175);
    } else {
    if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1176);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1177);
    } else {
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1179);
    }
    }
    } else if (genFeature.isPrimitiveType() || genFeature.isEnumType()) {
    if (genClass.isField(genFeature)) {
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_1180);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1182);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1183);
    } else {
    stringBuffer.append(TEXT_1184);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1185);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1186);
    }
    } else {
    if (genFeature.isEnumType() && genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1187);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1188);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1189);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1190);
    } else {
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1192);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1193);
    }
    }
    } else {//datatype
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1197);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1198);
    } else {
    if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(genFeature.getImportedType());
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1206);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1208);
    } else {
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1210);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1212);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_1213);
    }
    }
    }
    }
    }
    stringBuffer.append(TEXT_1214);
    if (genModel.isMinimalReflectiveMethods()) {
    stringBuffer.append(TEXT_1215);
    } else {
    stringBuffer.append(TEXT_1216);
    }
    stringBuffer.append(TEXT_1217);
    //Class/eIsSet.override.javajetinc
    }
    if (isImplementation && !genClass.getMixinGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_1218);
    for (Iterator m=genClass.getMixinGenClasses().iterator(); m.hasNext();) { GenClass mixinGenClass = (GenClass)m.next(); 
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(mixinGenClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_1220);
    for (Iterator f=mixinGenClass.getGenFeatures().iterator(); f.hasNext();) { GenFeature genFeature = (GenFeature)f.next(); 
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(mixinGenClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1223);
    }
    stringBuffer.append(TEXT_1224);
    }
    stringBuffer.append(TEXT_1225);
    for (Iterator m=genClass.getMixinGenClasses().iterator(); m.hasNext();) { GenClass mixinGenClass = (GenClass)m.next(); 
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(mixinGenClass.getImportedInterfaceName());
    stringBuffer.append(TEXT_1227);
    for (Iterator f=mixinGenClass.getGenFeatures().iterator(); f.hasNext();) { GenFeature genFeature = (GenFeature)f.next(); 
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(mixinGenClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1230);
    }
    stringBuffer.append(TEXT_1231);
    }
    stringBuffer.append(TEXT_1232);
    }
    if (isImplementation && genModel.isVirtualDelegation()) { String eVirtualValuesField = genClass.getEVirtualValuesField();
    if (eVirtualValuesField != null) {
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(eVirtualValuesField);
    stringBuffer.append(TEXT_1234);
    stringBuffer.append(eVirtualValuesField);
    stringBuffer.append(TEXT_1235);
    }
    { List eVirtualIndexBitFields = genClass.getEVirtualIndexBitFields(new ArrayList());
    if (!eVirtualIndexBitFields.isEmpty()) { List allEVirtualIndexBitFields = genClass.getAllEVirtualIndexBitFields(new ArrayList());
    stringBuffer.append(TEXT_1236);
    for (int i = 0; i < allEVirtualIndexBitFields.size(); i++) {
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(allEVirtualIndexBitFields.get(i));
    stringBuffer.append(TEXT_1239);
    }
    stringBuffer.append(TEXT_1240);
    for (int i = 0; i < allEVirtualIndexBitFields.size(); i++) {
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_1242);
    stringBuffer.append(allEVirtualIndexBitFields.get(i));
    stringBuffer.append(TEXT_1243);
    }
    stringBuffer.append(TEXT_1244);
    }
    }
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && !genClass.getToStringGenFeatures().isEmpty()) {
    stringBuffer.append(TEXT_1245);
    { boolean first = true;
    for (Iterator i=genClass.getToStringGenFeatures().iterator(); i.hasNext(); ) { GenFeature genFeature = (GenFeature)i.next();
    if (first) { first = false;
    stringBuffer.append(TEXT_1246);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_1247);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_1249);
    stringBuffer.append(genModel.getNonNLS());
    }
    if (genFeature.isUnsettable() && !genFeature.isListType()) {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1250);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_1253);
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_1254);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1256);
    } else {
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_1257);
    }
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_1259);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1260);
    stringBuffer.append(genModel.getNonNLS());
    } else {
    stringBuffer.append(TEXT_1261);
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_1262);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_1263);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1264);
    } else {
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_1265);
    }
    stringBuffer.append(TEXT_1266);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(genModel.getNonNLS());
    }
    }
    } else {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1268);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    if (!genFeature.isListType() && !genFeature.isReferenceType()){
    stringBuffer.append(TEXT_1269);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1270);
    }
    stringBuffer.append(TEXT_1271);
    } else {
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_1272);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_1273);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_1274);
    } else {
    stringBuffer.append(TEXT_1275);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_1276);
    }
    }
    }
    }
    }
    stringBuffer.append(TEXT_1277);
    }
    if (isImplementation && genClass.isMapEntry()) { GenFeature keyFeature = genClass.getMapEntryKeyFeature(); GenFeature valueFeature = genClass.getMapEntryValueFeature();
    stringBuffer.append(TEXT_1278);
    if (keyFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1279);
    stringBuffer.append(keyFeature.getObjectType());
    stringBuffer.append(TEXT_1280);
    } else {
    stringBuffer.append(TEXT_1281);
    }
    stringBuffer.append(TEXT_1282);
    if (keyFeature.isListType()) {
    stringBuffer.append(TEXT_1283);
    stringBuffer.append(genModel.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_1284);
    } else if (keyFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1285);
    stringBuffer.append(keyFeature.getObjectType());
    stringBuffer.append(TEXT_1286);
    stringBuffer.append(keyFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_1287);
    } else {
    stringBuffer.append(TEXT_1288);
    stringBuffer.append(keyFeature.getImportedType());
    stringBuffer.append(TEXT_1289);
    }
    stringBuffer.append(TEXT_1290);
    if (valueFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1291);
    stringBuffer.append(valueFeature.getObjectType());
    stringBuffer.append(TEXT_1292);
    } else {
    stringBuffer.append(TEXT_1293);
    }
    stringBuffer.append(TEXT_1294);
    if (valueFeature.isListType()) {
    stringBuffer.append(TEXT_1295);
    stringBuffer.append(genModel.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_1296);
    } else if (valueFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_1297);
    stringBuffer.append(valueFeature.getObjectType());
    stringBuffer.append(TEXT_1298);
    stringBuffer.append(valueFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_1299);
    } else {
    stringBuffer.append(TEXT_1300);
    stringBuffer.append(valueFeature.getImportedType());
    stringBuffer.append(TEXT_1301);
    }
    stringBuffer.append(TEXT_1302);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1303);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_1304);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.EMap"));
    stringBuffer.append(TEXT_1305);
    }
    stringBuffer.append(TEXT_1306);
    stringBuffer.append(isInterface ? " " + genClass.getInterfaceName() : genClass.getClassName());
    // TODO fix the space above
    genModel.emitSortedImports();
    return stringBuffer.toString();
  }
}
