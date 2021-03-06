/*
   Copyright (c) 2017 TOSHIBA Digital Solutions Corporation

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
package com.toshiba.mwcloud.gs;

/**
 * The options for fetching the result of a query.
 */
public enum FetchOption {

	/**
	 * Used to set the maximum number of Rows to be fetched.
	 *
	 * <p>If the number of Rows in a result exceeds the maximum, the maximum number of
	 * Rows counting from the 0-th in {@link RowSet} are fetched. The rest of the Rows
	 * in the result cannot be fetched. </p>
	 *
	 * <p>The supported types of values are {@link Integer} and {@link Long}. Negative values are not available.
	 * If the setting is omitted, the limit is not defined. </p>
	 */
	LIMIT,

	/**
	 * @deprecated
	 */
	@Deprecated
	SIZE,

	/**
	 * Used to set the partial execution mode.
	 *
	 * <p>In the partial execution mode, it is trying for the
	 * buffer size of the intermediate query processing and the
	 * data transfer, etc. to fit inside a fixed size by dividing
	 * the target data and getting the query results in each
	 * divided range. Therefore the results for some data ranges may
	 * not be determined when the {@link RowSet} is obtained,
	 * and in the middle of getting the results,
	 * there are the cases that the query is executed partially
	 * for the rest of the ranges.</p>
	 *
	 * <p>In this version, the partial execution mode can be used
	 * for queries satisfying all the following conditions.
	 * And it can be used in combination with {@link #LIMIT}
	 * option. Even if not satisfying the conditions, the error may
	 * not be detected when setting the fetch option.</p>
	 * <ul>
	 * <li>The query must be specified by TQL</li>
	 * <li>The SELECT clause must be consisted of only '*' and an
	 * ORDER BY clause must not be specified.</li>
	 * <li>The target {@link Container} must have been set to the
	 * auto commit mode at the each partial execution of the
	 * query.</li>
	 * </ul>
	 *
	 * <p>In the partial execution mode, rows that can be fetched
	 * at the each partial execution of the query based on the
	 * separation level and the status of the corresponding
	 * {@link Container} transaction are used. However rows that
	 * don't exist at the first time of the whole query execution
	 * may not be reflected to the results.</p>
	 *
	 * <p>For inhibited operations and behaviors on {@link RowSet}
	 * in this mode, see the individual definitions.</p>
	 *
	 * <p>The only supported type for this setting is {@link Boolean}.
	 * The value matching to {@link Boolean#TRUE} must
	 * be specified to activate this mode. In this version, the
	 * partial execution mode is not effective unless setting the
	 * mode explicitly.</p>
	 *
	 */
	PARTIAL_EXECUTION

}
