<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Copyright (c) 2005, 2007 IBM Corporation and others.
    All rights reserved. This program and the accompanying materials
    are made available under the terms of the Eclipse Public License v1.0
    which accompanies this distribution, and is available at
    http://www.eclipse.org/legal/epl-v10.html
    Contributors:
    IBM Corporation - initial implementation
-->

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">

	<xsl:template name="addChecklists">
		<xsl:param name="checklists"/>
		<xsl:if test="count($checklists) > 0">
			<tr valign="top">
				<th class="sectionTableHeading" scope="row">
					<xsl:value-of select="$checklistsText"/>
				</th>
				<td class="sectionTableCell">
					<ul>
						<xsl:for-each select="$checklists">
							<li>
								<xsl:call-template name="addElementWithLink">
									<xsl:with-param name="element" select="."/>
								</xsl:call-template>
							</li>
						</xsl:for-each>
					</ul>
				</td>
			</tr>
		</xsl:if>
	</xsl:template>

	<xsl:template name="addConcepts">
		<xsl:param name="concepts"/>
		<xsl:if test="count($concepts) > 0">
			<tr valign="top">
				<th class="sectionTableHeading" scope="row">
					<xsl:value-of select="$conceptsText"/>
				</th>
				<td class="sectionTableCell">
					<ul>
						<xsl:for-each select="$concepts">
							<li>
								<xsl:call-template name="addElementWithLink">
									<xsl:with-param name="element" select="."/>
								</xsl:call-template>
							</li>
						</xsl:for-each>
					</ul>
				</td>
			</tr>
		</xsl:if>
	</xsl:template>

	<xsl:template name="addEstimationConsiderations">
		<xsl:param name="estimationConsiderations"/>
		<xsl:if test="count($estimationConsiderations) > 0">
			<tr valign="top">
				<th class="sectionTableHeading" scope="row">
					<xsl:value-of select="$estimationConsiderationsText"/>
				</th>
				<td class="sectionTableCell">
					<ul>
						<xsl:for-each select="$estimationConsiderations">
							<li>
								<xsl:call-template name="addElementWithLink">
									<xsl:with-param name="element" select="."/>
								</xsl:call-template>
							</li>
						</xsl:for-each>
					</ul>
				</td>
			</tr>
		</xsl:if>
	</xsl:template>

	<xsl:template name="addExamples">
		<xsl:param name="examples"/>
		<xsl:if test="count($examples) > 0">
			<tr valign="top">
				<th class="sectionTableHeading" scope="row">
					<xsl:value-of select="$examplesText"/>
				</th>
				<td class="sectionTableCell">
					<ul>
						<xsl:for-each select="$examples">
							<li>
								<xsl:call-template name="addElementWithLink">
									<xsl:with-param name="element" select="."/>
								</xsl:call-template>
							</li>
						</xsl:for-each>
					</ul>
				</td>
			</tr>
		</xsl:if>
	</xsl:template>

	<xsl:template name="addGuidelines">
		<xsl:param name="guidelines"/>
		<xsl:if test="count($guidelines) > 0">
			<tr valign="top">
				<th class="sectionTableHeading" scope="row">
					<xsl:value-of select="$guidelinesText"/>
				</th>
				<td class="sectionTableCell">
					<ul>
						<xsl:for-each select="$guidelines">
							<li>
								<xsl:call-template name="addElementWithLink">
									<xsl:with-param name="element" select="."/>
								</xsl:call-template>
							</li>
						</xsl:for-each>
					</ul>
				</td>
			</tr>
		</xsl:if>
	</xsl:template>

	<xsl:template name="addReports">
		<xsl:param name="reports"/>
		<xsl:if test="count($reports) > 0">
			<tr valign="top">
				<th class="sectionTableHeading" scope="row">
					<xsl:value-of select="$reportsText"/>
				</th>
				<td class="sectionTableCell">
					<ul>
						<xsl:for-each select="$reports">
							<li>
								<xsl:call-template name="addElementWithLink">
									<xsl:with-param name="element" select="."/>
								</xsl:call-template>
							</li>
						</xsl:for-each>
					</ul>
				</td>
			</tr>
		</xsl:if>
	</xsl:template>

	<xsl:template name="addReusableAssets">
		<xsl:param name="reusableAssets"/>
		<xsl:if test="count($reusableAssets) > 0">
			<tr valign="top">
				<th class="sectionTableHeading" scope="row">
					<xsl:value-of select="$reusableAssetsText"/>
				</th>
				<td class="sectionTableCell">
					<ul>
						<xsl:for-each select="$reusableAssets">
							<li>
								<xsl:call-template name="addElementWithLink">
									<xsl:with-param name="element" select="."/>
								</xsl:call-template>
							</li>
						</xsl:for-each>
					</ul>
				</td>
			</tr>
		</xsl:if>
	</xsl:template>

	<xsl:template name="addSupportingMaterials">
		<xsl:param name="supportingMaterials"/>
		<xsl:if test="count($supportingMaterials) > 0">
			<tr valign="top">
				<th class="sectionTableHeading" scope="row">
					<xsl:value-of select="$supportingMaterialsText"/>
				</th>
				<td class="sectionTableCell">
					<ul>
						<xsl:for-each select="$supportingMaterials">
							<li>
								<xsl:call-template name="addElementWithLink">
									<xsl:with-param name="element" select="."/>
								</xsl:call-template>
							</li>
						</xsl:for-each>
					</ul>
				</td>
			</tr>
		</xsl:if>
	</xsl:template>

	<xsl:template name="addTechniques">
		<xsl:param name="techniques"/>
		<xsl:if test="count($techniques) > 0">
			<tr valign="top">
				<th class="sectionTableHeading" scope="row">
					<xsl:value-of select="$techniquesText"/>
				</th>
				<td class="sectionTableCell">
					<ul>
						<xsl:for-each select="$techniques">
							<li>
								<xsl:call-template name="addElementWithLink">
									<xsl:with-param name="element" select="."/>
								</xsl:call-template>
							</li>
						</xsl:for-each>
					</ul>
				</td>
			</tr>
		</xsl:if>
	</xsl:template>

	<xsl:template name="addTemplates">
		<xsl:param name="templates"/>
		<xsl:if test="count($templates) > 0">
			<tr valign="top">
				<th class="sectionTableHeading" scope="row">
					<xsl:value-of select="$templatesText"/>
				</th>
				<td class="sectionTableCell">
					<ul>
						<xsl:for-each select="$templates">
							<li>
								<xsl:call-template name="addElementWithLink">
									<xsl:with-param name="element" select="."/>
								</xsl:call-template>
							</li>
						</xsl:for-each>
					</ul>
				</td>
			</tr>
		</xsl:if>
	</xsl:template>

	<xsl:template name="addWhitePapers">
		<xsl:param name="whitePapers"/>
		<xsl:if test="count($whitePapers) > 0">
			<tr valign="top">
				<th class="sectionTableHeading" scope="row">
					<xsl:value-of select="$whitepapersText"/>
				</th>
				<td class="sectionTableCell">
					<ul>
						<xsl:for-each select="$whitePapers">
							<li>
								<xsl:call-template name="addElementWithLink">
									<xsl:with-param name="element" select="."/>
								</xsl:call-template>
							</li>
						</xsl:for-each>
					</ul>
				</td>
			</tr>
		</xsl:if>
	</xsl:template>

	<xsl:template name="addToolMentors">
		<xsl:param name="toolMentors"/>
		<xsl:if test="count($toolMentors) > 0">
			<tr valign="top">
				<th class="sectionTableHeading" scope="row">
					<xsl:value-of select="$toolMentorsText"/>
				</th>
				<td class="sectionTableCell">
					<ul>
						<xsl:for-each select="$toolMentors">
							<li>
								<xsl:call-template name="addElementWithLink">
									<xsl:with-param name="element" select="."/>
								</xsl:call-template>
							</li>
						</xsl:for-each>
					</ul>
				</td>
			</tr>
		</xsl:if>
	</xsl:template>

</xsl:stylesheet>