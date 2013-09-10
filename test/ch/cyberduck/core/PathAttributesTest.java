package ch.cyberduck.core;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @version $Id$
 */
public class PathAttributesTest extends AbstractTestCase {

    @Test
    public void testGetAsDictionary() throws Exception {
        PathAttributes attributes = new PathAttributes(Path.VOLUME_TYPE | Path.DIRECTORY_TYPE);
        attributes.setSize(3L);
        attributes.setModificationDate(5343L);
        assertEquals(attributes, new PathAttributes(attributes.serialize(SerializerFactory.get())));
        assertEquals(attributes.hashCode(), new PathAttributes(attributes.serialize(SerializerFactory.get())).hashCode());
    }

    @Test
    public void testTypeVolume() throws Exception {
        PathAttributes attributes = new PathAttributes(Path.VOLUME_TYPE | Path.DIRECTORY_TYPE);
        assertTrue(attributes.isVolume());
        assertTrue(attributes.isDirectory());
        assertFalse(attributes.isFile());
        assertFalse(attributes.isSymbolicLink());
    }

    @Test
    public void testTypeFile() throws Exception {
        PathAttributes attributes = new PathAttributes(Path.FILE_TYPE | Path.SYMBOLIC_LINK_TYPE);
        assertFalse(attributes.isVolume());
        assertFalse(attributes.isDirectory());
        assertTrue(attributes.isFile());
        assertTrue(attributes.isSymbolicLink());
    }

    @Test
    public void testPermissions() throws Exception {
        PathAttributes attributes = new PathAttributes(Path.FILE_TYPE);
        assertNull(attributes.getOwner());
        assertNull(attributes.getGroup());
        assertNotNull(attributes.getPermission());
        assertEquals(Permission.EMPTY, attributes.getPermission());
        assertEquals(Acl.EMPTY, attributes.getAcl());
    }

    @Test
    public void testSerialize() throws Exception {
        PathAttributes attributes = new PathAttributes(Path.FILE_TYPE);
        attributes.setPermission(new Permission(644));
        attributes.setDuplicate(true);
        attributes.setVersionId("v-1");
        attributes.setModificationDate(System.currentTimeMillis());
        assertEquals(attributes, new PathAttributes(attributes.serialize(SerializerFactory.get())));
        assertEquals(attributes.hashCode(), new PathAttributes(attributes.serialize(SerializerFactory.get())).hashCode());
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(new PathAttributes(Path.FILE_TYPE).equals(new PathAttributes(Path.FILE_TYPE)));
        assertFalse(new PathAttributes(Path.FILE_TYPE).equals(new PathAttributes(Path.DIRECTORY_TYPE)));
        final PathAttributes r1 = new PathAttributes(Path.FILE_TYPE);
        r1.setRegion("r1");
        final PathAttributes r2 = new PathAttributes(Path.FILE_TYPE);
        r2.setRegion("r2");
        assertFalse(r1.equals(r2));
    }
}
