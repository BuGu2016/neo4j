/**
 * Copyright (c) 2002-2014 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.register;

/**
 * Collection of common register types.
 */
public interface Register
{
    interface DoubleLongRegister extends DoubleLong.In, DoubleLong.Out {}
    interface DoubleLong
    {
        interface In
        {
            long readFirst();
            long readSecond();

            void copyTo( Out target );
        }

        interface Out
        {
            void write( long first, long second );
            void increment( long firstDelta, long secondDelta );

            void writeFirst( long value );
            void writeSecond( long value );
        }
    }

    interface LongRegister extends Long.In, Long.Out {}
    interface Long
    {
        interface In
        {
            long read();
        }

        interface Out
        {
            void write( long value );
            long increment( long delta );
        }
    }

    interface IntRegister extends Int.In, Int.Out {}
    interface Int
    {
        interface In
        {
            int read();
        }

        interface Out
        {
            void write( int value );
            int increment( int delta );
        }
    }

    interface ObjectRegister<T> extends Object.In<T>, Object.Out<T> {}
    interface Object
    {
        interface In<T>
        {
            T read();
        }

        interface Out<T>
        {
            void write(T value);
        }

    }
}
