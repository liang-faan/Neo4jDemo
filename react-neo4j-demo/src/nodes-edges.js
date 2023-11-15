const position = { x: 0, y: 0 };
const edgeType = 'default';
const animated = false;

export const initalGroups = [
  {
    id: 'A',
    type: 'group',
    data: { label: 'A Group' }
  },
  {
    id: 'B',
    type: 'group',
    data: { label: 'B Group' }
  }
];

export const swimlaneNodes = [
  {
    id: 's1',
    // type: 'group',
    data: {
      label: "Swimlane A"
    }
  },
  {
    id: 's2',
    // type: 'CustomNode',
    data: {
      label: "Swimlane B"
    }
  },
  {
    id: 's3',
    // type: 'CustomNode',
    data: {
      label: "Swimlane C"
    }
  }
]

export const initialNodes = [
  // {
  //   id: 'A',
  //   type: 'group',
  //   data: { label: 'Group A' },
  //   position,
  //   style: {
  //     width: 250,
  //     height: 250,
  //   },
  // },
  {
    id: '1',
    type: 'input',
    data: { label: 'input1' },
    position,
  },
  {
    id: '2',
    data: { label: 'node 2' },
    position,
  },
  {
    id: '2a',
    data: { label: 'node 2a' },
    position,
  },
  {
    id: '2b',
    data: { label: 'node 2b' },
    position,
  },
  {
    id: '2c',
    data: { label: 'node 2c' },
    position,
  },
  {
    id: '2d',
    data: { label: 'node 2d' },
    position,
  },
  {
    id: '3',
    data: { label: 'node 3' },
    position,
  },
  {
    id: '4',
    data: { label: 'node 4' },
    position,
  },
  {
    id: '5',
    data: { label: 'node 5' },
    position,
  },
  {
    id: '6',
    type: 'output',
    data: { label: 'output6' },
    position,
  },
  { id: '7', type: 'output', data: { label: 'output7' }, position },
];

export const initialEdges = [
  { id: 'e12', source: '1', target: '2', type: edgeType, animated: animated },
  { id: 'e13', source: '1', target: '3', type: edgeType, animated: animated },
  { id: 'e22a', source: '2', target: '2a', type: edgeType, animated: animated },
  { id: 'e22b', source: '2', target: '2b', type: edgeType, animated: animated },
  { id: 'e22c', source: '2', target: '2c', type: edgeType, animated: animated },
  { id: 'e2c2d', source: '2c', target: '2d', type: edgeType, animated: animated },
  { id: 'e45', source: '4', target: '5', type: edgeType, animated: animated },
  { id: 'e56', source: '5', target: '6', type: edgeType, animated: animated },
  { id: 'e57', source: '5', target: '7', type: edgeType, animated: animated },
];

export const SWIMLANE_GROUP_NODES = [
  {
    id: "1",
    name: "Channel Group",
    children: [
      {
        id: "11",
        name: "POS"
      },
      {
        id: "12",
        name: "POS Marchant"
      }
    ]
  },
  {
    id: "2",
    name: "Integration",
    children: [
      {
        id: "21",
        name: "APIG"
      },
      {
        id: "22",
        name: "SIAM"
      }
    ]
  },
  {
    id: "3",
    name: "Service Layer",
    children: [
      {
        id: "31",
        name: "Service App1"
      },
      {
        id: "32",
        name: "Service App2"
      },
      {
        id: "33",
        name: "Service App3"
      },
      {
        id: "34",
        name: "Service App4"
      },
      {
        id: "35",
        name: "Service App5"
      },
      {
        id: "36",
        name: "Service App6"
      },
      {
        id: "37",
        name: "Service App7"
      },
      {
        id: "38",
        name: "Service App8"
      }
    ]
  },
  {
    id: "4",
    name: "Mainframe Layer",
    children: [
      {
        id: "41",
        name: "Mainframe App1"
      },
      {
        id: "42",
        name: "Mainframe App2"
      },
      {
        id: "43",
        name: "Mainframe App3"
      },
      {
        id: "44",
        name: "Mainframe App4"
      },
      {
        id: "45",
        name: "Mainframe App5"
      },
      {
        id: "46",
        name: "Mainframe App6"
      },
      {
        id: "47",
        name: "Mainframe App7"
      },
      {
        id: "48",
        name: "Mainframe App8"
      }
    ]
  }
];